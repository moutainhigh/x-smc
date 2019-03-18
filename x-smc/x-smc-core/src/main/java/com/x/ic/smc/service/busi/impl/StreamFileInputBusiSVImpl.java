package com.x.ic.smc.service.busi.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import com.ai.baas.rtm.api.datacollect.params.JsDataVO;
import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.sdk.util.DateUtil;
import com.x.sdk.util.StringUtil;
import com.x.rtm.api.datacollect.params.JsDataVO;
import com.x.ic.smc.api.streamfilemanage.param.StreamFileParam;
import com.x.ic.smc.constants.SmcCacheConstant.ParamCode;
import com.x.ic.smc.constants.SmcCacheConstant.TypeCode;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.dao.mapper.bo.StlImportLog;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.service.atom.interfaces.IImportLogAtomSV;
import com.x.ic.smc.service.busi.interfaces.IStreamFileInputBusiSV;
import com.x.ic.smc.util.AntZipUtil;
import com.x.ic.smc.util.CpDetectorUtil;
import com.x.ic.smc.util.HttpClientUtil;
import com.x.ic.smc.util.RedisUtil;
import com.x.ic.smc.util.SmcSeqUtil;
import com.x.ic.smc.util.SysParamUtil;
import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

@Component
@Transactional
public class StreamFileInputBusiSVImpl implements IStreamFileInputBusiSV {
    private static final Logger LOGGER = LogManager.getLogger(StreamFileInputBusiSVImpl.class);

    @Autowired
    private transient IImportLogAtomSV importLogAtomSV;

    @Override
    public void inport(StreamFileParam request) {
        String tenantId = request.getTenantId();
        String impFileUrl = request.getFilePosition();
        // String file=streamFileParam.getFilePosition()+"\\"+streamFileParam.getFileName();
        String batchNo = "";
        String saveFile = downFile(impFileUrl, request.getFileName(), tenantId);
        File file = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        // 校验csv文件编码是否是utf-8
        checkZipFileEncode(saveFile);
        try {
            // 2. 从指定的文件服务器上解压文件，获取文件列表。
            ZipFile zipFile = new ZipFile(saveFile);
            List<ZipEntry> zipEntries = new ArrayList<ZipEntry>();
            for (@SuppressWarnings("rawtypes")
            Enumeration entries = zipFile.entries(); entries.hasMoreElements();) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (zipEntry.isDirectory()) {
                    continue;
                }
                String zipEntryName = zipEntry.getName();
                LOGGER.info(zipEntryName);
                if (zipEntryName.endsWith(".csv") || zipEntryName.endsWith(".txt")) {
                    zipEntries.add(zipEntry);
                }
            }

//            InputStream in = new BufferedInputStream(new FileInputStream(file));
//            ZipInputStream zin = new ZipInputStream(in);
            int totalRecord = 0;

            for (ZipEntry zipEntry : zipEntries) {
                String zipEntryName = zipEntry.getName();
                LOGGER.info(zipEntryName);
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                inputStreamReader = new InputStreamReader(inputStream, SmcConstants.CHARSET_UTF8);
                bufferedReader = new BufferedReader(inputStreamReader);
                
                String aLine = bufferedReader.readLine();
                if (StringUtil.isBlank(aLine)) {
                    LOGGER.info("[" + zipEntryName + "] 读取的headerLine行是空的，继续下一个文件");
                    continue;
                }
                
                String[] headerLine;
                if (zipEntryName.endsWith(".csv")) {
                    headerLine = aLine.split(",");
                } else {
                    headerLine = aLine.split(SmcConstants.FIELD_SPLIT);
                }
                String batchNoTmp = headerLine[1];
                if (StringUtil.isBlank(batchNo)) {
                    batchNo = batchNoTmp;
                } else {
                    if (!batchNo.equals(batchNoTmp)) {
                        throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "文件["
                                + zipEntryName + "]批次号不一致");
                    }
                }

                if (totalRecord == 0) {
                    totalRecord = Integer.parseInt(headerLine[3]);
                }
                String thisRecord = headerLine[5];
                LOGGER.error(" ====== thisRecord = " + thisRecord);
                if (!batchNo.equals(batchNoTmp)) {
                    throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "文件["
                            + zipEntry.getName() + "]批次号不一致");
                }
                bufferedReader.readLine();
                int count = 0;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (StringUtil.isBlank(line)) {
                        break;
                    }
                    count++;
                }
                if (Integer.parseInt(thisRecord) != count) {
                    throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "文件["
                            + zipEntry.getName() + "]记录数不一致");
                }
            }
            if (StringUtil.isBlank(batchNo)) {
                throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "批次号为空");
            }
            // 校验批次号是否已存在
            if (importLogAtomSV.isExistBatchNo(tenantId, batchNo)) {
                throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "该批次号["
                        + batchNo + "]文件已导入");
            }
            
            // key:busidata_租户ID _批次号_stats_times
         	// value:业务数据_租户ID _批次号__完成记录数
            //清空redis中统计数
            String countKey = assemCountKey("busidata", tenantId, batchNo, "stats_times");
            RedisUtil.getCacheClient().del(countKey);
            
            String jSBsn = "JS" + tenantId + batchNo;
            String address = SysParamUtil
                    .getSysParams(request.getTenantId(), TypeCode.DATA_COLLECT, ParamCode.URL)
                    .get(0).getColumnValue();
            this.insertLog(request, batchNo, totalRecord);
            for (ZipEntry zipEntry : zipEntries) {
                InputStream inputStream;
                inputStream = zipFile.getInputStream(zipEntry);

                inputStreamReader = new InputStreamReader(inputStream, SmcConstants.CHARSET_UTF8);
                bufferedReader = new BufferedReader(inputStreamReader);

                bufferedReader.readLine();
                bufferedReader.readLine();
                // 消息头
                String userId = SysParamUtil
                        .getSysParams(request.getTenantId(), TypeCode.AUTH, ParamCode.USER_ID)
                        .get(0).getColumnValue();
                String passwd = SysParamUtil
                        .getSysParams(request.getTenantId(), TypeCode.AUTH, ParamCode.PAASWD)
                        .get(0).getColumnValue();
                String header = new StringBuilder().append(tenantId)
                        .append(SmcConstants.HEADER_SPLIT).append(request.getDataObj())
                        .append(SmcConstants.HEADER_SPLIT).append(batchNo)
                        .append(SmcConstants.HEADER_SPLIT).append(userId)
                        .append(SmcConstants.HEADER_SPLIT).append(passwd)
                        .append(SmcConstants.HEADER_SPLIT).toString();

                while (true) {
                    String line = bufferedReader.readLine();
                    if (StringUtil.isBlank(line)) {
                        break;
                    }
                    if (zipEntry.getName().endsWith(".csv")) {
                        line = line.replaceAll(SmcConstants.CVSFILE_FEILD_SPLIT,
                                SmcConstants.FIELD_SPLIT);
                    }
                    String message = new StringBuilder(header).append(request.getDataObj())
                            .append(SmcConstants.FIELD_SPLIT).append(batchNo)
                            .append(SmcConstants.FIELD_SPLIT).append(totalRecord)
                            .append(SmcConstants.FIELD_SPLIT).append(line).toString();
                    JsDataVO dataVO = new JsDataVO();
                    dataVO.setMessage(message);
                    dataVO.setjSBsn(jSBsn);
                    LOGGER.error(" ====== 调用采集服务:[" + JSON.toJSONString(dataVO) + "]");
                    HttpResponse httpResponse = HttpClientUtil.send(address,
                            JSON.toJSONString(dataVO));
                    LOGGER.info("httpResponse.getStatusLine() = " + httpResponse.getStatusLine());
                }
            }

            JsDataVO jsDataVO = new JsDataVO();
            jsDataVO.setjSBsn("JS0000");
            HttpClientUtil.send(address, JSON.toJSONString(jsDataVO));

//            zin.close();
            zipFile.close();
        } catch (IOException e) {
            throw new SystemException(e);
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    LOGGER.error("Failed to close inputStreamReader", e);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    LOGGER.error("Failed to close bufferedReader", e);
                }
            }
        }
    }

    private String downFile(String impFileUrl, String impFileName, String tenantId) {
        String host = impFileUrl.split(":")[0];
        String filePathFtp = impFileUrl.split(":")[1];
        String username = SysParamUtil
                .getSysParams(tenantId, TypeCode.SFTP_CONF, ParamCode.USER_NAME).get(0)
                .getColumnValue();
        String password = SysParamUtil.getSysParams(tenantId, TypeCode.SFTP_CONF, ParamCode.PWD)
                .get(0).getColumnValue();
        String tmpLocalPath = System.getProperty("user.dir");// 本地暂存
        String saveFile = tmpLocalPath + "/tmp/" + tenantId + "/"
                + DateUtil.getDateString(DateUtil.yyyyMMddHHmmssSSS) + "/" + impFileName;
        LOGGER.info(" ====== 账单文件本地暂存:[" + saveFile + "]");
        File file = new File(saveFile);
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                throw new SystemException("创建临时目录失败[" + file.getParentFile().getName() + "]");
            }
        }
        Session session = null;
        Channel channel = null;
        JSch jsch = new JSch();
        // 建立sftp连接
        try {
            session = jsch.getSession(username, host, 22);
            session.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            session.setConfig(sshConfig);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftp = (ChannelSftp) channel;
            sftp.cd(filePathFtp);

            sftp.get(impFileName, saveFile);
        } catch (JSchException | SftpException e) {
            throw new SystemException(e);
        } finally {
            disconnect(session, channel);
        }
        return saveFile;
    }

    private void checkZipFileEncode(String saveFile) {
        String unZipFilePath = saveFile.substring(0, saveFile.lastIndexOf("."));
        AntZipUtil.unzip(saveFile, unZipFilePath);
        checkFileEncode(unZipFilePath);
    }

    private void checkFileEncode(String filePath) {
        File file = new File(filePath);
        if (file != null) {
            for (File fileTmp : file.listFiles()) {
                if (fileTmp.isDirectory()) {
                    checkFileEncode(fileTmp.getAbsolutePath());
                } else {
                    if (fileTmp.getName().endsWith(".csv") || fileTmp.getName().endsWith(".txt")) {
                        if (!SmcConstants.CHARSET_UTF8
                                .equals(CpDetectorUtil.getFileEncode(fileTmp))) {
                            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION,
                                    "文件[" + fileTmp.getName() + "]编码必须是utf-8");
                        }
                    }
                }
            }
        }
    }

    public void insertLog(StreamFileParam streamFileParam, String batchNo, int totalRecord) {
        Long logId = SmcSeqUtil.createLogId();
        StlImportLog stlImportLog = new StlImportLog();
        stlImportLog.setLogId(logId);
        stlImportLog.setTenantId(streamFileParam.getTenantId());
        stlImportLog.setImpFileName(streamFileParam.getFileName());
        stlImportLog.setImpFileUrl(streamFileParam.getFilePosition());
        stlImportLog.setDataType(SmcConstants.StlImportLog.DataType.ORDER);
        stlImportLog.setObjectId(streamFileParam.getDataObj());
        stlImportLog.setBillTimeSn(streamFileParam.getAccountPeriod());
        stlImportLog.setImportTime(DateUtil.getSysDate());
        stlImportLog.setImportRecords((long) totalRecord);
        stlImportLog.setBatchNo(batchNo);
        stlImportLog.setState(SmcConstants.StlImportLog.State.IMPORT_SUCCESS);
        stlImportLog.setStateDesc(SmcConstants.StlImportLog.StateDesc.IMPORT_SUCCESS);
        stlImportLog.setOptDeptId(streamFileParam.getOperDept());
        stlImportLog.setOptOperId(streamFileParam.getOperId());
        stlImportLog.setStateChgTime(DateUtil.getSysDate());
        MapperFactory.getStlImportLogMapper().insert(stlImportLog);
        importLogAtomSV.writeLogToCache(stlImportLog);
    }
    
    private String assemCountKey(String busidata, String tenantId, String batchNo, String stats_times) {
		StringBuilder sb = new StringBuilder();
		sb.append(busidata);
		sb.append("_");
		sb.append(tenantId);
		sb.append("_");
		sb.append(batchNo);
		sb.append("_");
		sb.append(stats_times);
		return sb.toString();
	}

    void disconnect(Session session, Channel channel) {
        if (channel != null) {
            if (channel.isConnected()) {
                channel.disconnect();
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }

    }

}
