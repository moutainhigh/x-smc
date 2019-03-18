package com.x.ic.smc.service.busi.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Properties;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.base.exception.SystemException;
import com.x.base.vo.BaseResponse;
import com.x.base.vo.HBasePager;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.BeanUtils;
import com.x.sdk.util.CollectionUtil;
import com.x.sdk.util.DateUtil;
import com.x.sdk.util.StringUtil;
import com.x.rtm.api.datacollect.params.JsDataVO;
import com.x.ic.smc.api.billdetail.param.BillDetailDataImportRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultDiffDetailQueryRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultQueryRequest;
import com.x.ic.smc.api.billdetail.param.CheckResultQueryResponse;
import com.x.ic.smc.api.billdetail.param.DiffDetailDataInfo;
import com.x.ic.smc.api.billdetail.param.FeeItemData;
import com.x.ic.smc.api.billdetail.param.SettlementCheckStartRequest;
import com.x.ic.smc.constants.SmcCacheConstant;
import com.x.ic.smc.constants.SmcCacheConstant.ParamCode;
import com.x.ic.smc.constants.SmcCacheConstant.TypeCode;
import com.x.ic.smc.constants.SmcConstants;
import com.x.ic.smc.constants.SmcExceptCodeConstant;
import com.x.ic.smc.constants.SmcHbaseConstant;
import com.x.ic.smc.dao.mapper.bo.StlBillData;
import com.x.ic.smc.dao.mapper.bo.StlBillDataCriteria;
import com.x.ic.smc.dao.mapper.bo.StlBillItemData;
import com.x.ic.smc.dao.mapper.bo.StlBillItemDataCriteria;
import com.x.ic.smc.dao.mapper.bo.StlBillStyleItem;
import com.x.ic.smc.dao.mapper.bo.StlImportLog;
import com.x.ic.smc.dao.mapper.bo.StlImportLogCriteria;
import com.x.ic.smc.dao.mapper.bo.StlPolicy;
import com.x.ic.smc.dao.mapper.bo.StlPolicyCriteria;
import com.x.ic.smc.dao.mapper.factory.MapperFactory;
import com.x.ic.smc.service.atom.interfaces.IImportLogAtomSV;
import com.x.ic.smc.service.busi.interfaces.IBillDetailBusiSV;
import com.x.ic.smc.util.AntZipUtil;
import com.x.ic.smc.util.CpDetectorUtil;
import com.x.ic.smc.util.HbaseClient;
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
public class BillDetailBusiSVImpl implements IBillDetailBusiSV {
    private static final Logger LOGGER = LogManager.getLogger(BillDetailBusiSVImpl.class);

    @Autowired
    private transient IImportLogAtomSV importLogAtomSV;

    private void disconnect(Session session, Channel channel) {
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

    @Override
    public String importBillDetailData(BillDetailDataImportRequest request) {
        String tenantId = request.getTenantId();
        String impFileUrl = request.getImpFileUrl();
        Timestamp sysdate = DateUtil.getSysDate();
        String state = SmcConstants.StlImportLog.State.IMPORT_SUCCESS;
        String stateDesc = SmcConstants.StlImportLog.StateDesc.IMPORT_SUCCESS;
        String batchNo = null;
        /* 1 下载压缩包到本地 */
        String saveFile = downFile(impFileUrl, request.getImpFileName(), tenantId);
        // 校验csv文件编码是否是utf-8
        checkZipFileEncode(saveFile);
        // 根据文件名获得账单文件。
        String billFile = getBillFileIn(saveFile.substring(0, saveFile.lastIndexOf(".")));
        if (StringUtil.isBlank(billFile)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "账单文件不存在");
        }
        Workbook workBook = null;
        try {
            // 校验账单文件是否按模板格式提供，如果不符合则本次导入文件异常，记录异常原因并直接返回。
            File aBillFile = new File(billFile);
            if(! aBillFile.isAbsolute()){
                throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "[" + billFile + "]不是绝对路径");
            }
            workBook = WorkbookFactory.create(aBillFile);
            Sheet sheet = workBook.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            String stlElementSn = null;
            String policyCode = null;
            String billTimeSn = null;
            Timestamp billStartTime = null;
            Timestamp billEndTime = null;
            long origFee = 0;
            Map<String, Long> feeItemMap = null;
            for (int i = 0; rows.hasNext(); i++) {
                Row row = rows.next();
                if (i == 0) {
                    stlElementSn = row.getCell(1).getStringCellValue();
                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    batchNo = row.getCell(3).getStringCellValue();
                } else if (i == 1) {
                    policyCode = row.getCell(1).getStringCellValue();
                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    billTimeSn = row.getCell(3).getStringCellValue();
                } else if (i == 2) {
                    billStartTime = new Timestamp(row.getCell(1).getDateCellValue().getTime());
                    billEndTime = DateUtil.getTheDayLastSecond(new Timestamp(row.getCell(3)
                            .getDateCellValue().getTime()));
                } else if (i == 3) {
                    origFee = (long) (row.getCell(1).getNumericCellValue() * 1000);
                } else if (i > 5) {
                    if (feeItemMap == null) {
                        feeItemMap = new HashMap<String, Long>();
                    }
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    String feeItemId = row.getCell(0).getStringCellValue();
                    long totalFee = (long) (row.getCell(2).getNumericCellValue() * 1000);
                    if (StringUtil.isBlank(feeItemId)) {
                        break;
                    }
                    if (feeItemMap.containsKey(feeItemId)) {
                        feeItemMap.put(feeItemId, feeItemMap.get(feeItemId) + totalFee);
                    } else {
                        feeItemMap.put(feeItemId, totalFee);
                    }
                }
            }

            checkData(batchNo, stlElementSn, policyCode, billTimeSn, billStartTime, billEndTime);
            // 校验总金额是否一致
            checkTotalFee(origFee, feeItemMap);
            // 校验批次号是否已存在
            checkBatchNo(tenantId, batchNo);
            // 把账单文件的数据写入账单表及账单科目汇总表。
            StlPolicy stlPolicy = getStlPolicy(tenantId, policyCode);

            Long billId = writeBillData(request, sysdate, batchNo, stlElementSn, policyCode,
                    billTimeSn, billStartTime, billEndTime, origFee, stlPolicy);
            // 保存账单科目汇总表
            if (feeItemMap != null) {
                for (Entry<String, Long> entry : feeItemMap.entrySet()) {
                    writeBillItemData(request, sysdate, billId, entry);
                }
            }
            // 写入数据导入日志表。
            StlImportLog stlImportLog = writeImportLog(request, sysdate, state, stateDesc, batchNo);
            // 写入共享缓存
            importLogAtomSV.writeLogToCache(stlImportLog);
        } catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
            throw new SystemException(e);
        } finally {
            if (null != workBook) {
                try {
                    workBook.close();
                } catch (IOException e) {
                    LOGGER.error(e);
                }
            }
            deleteLocalTmpFile(new File(saveFile.substring(0, saveFile.lastIndexOf("/"))));
        }
        return batchNo;
    }

    private Long writeBillData(BillDetailDataImportRequest request, Timestamp sysdate,
            String batchNo, String stlElementSn, String policyCode, String billTimeSn,
            Timestamp billStartTime, Timestamp billEndTime, long origFee, StlPolicy stlPolicy) {
        Long billId = SmcSeqUtil.createBillId();
        StlBillData stlBillData = new StlBillData();
        stlBillData.setBillId(billId);
        stlBillData.setBillFrom(SmcConstants.StlBillData.BillFrom.IMPORT);
        stlBillData.setBatchNo(batchNo);
        stlBillData.setTenantId(request.getTenantId());
        stlBillData.setPolicyCode(policyCode);
        stlBillData.setStlObjectId(stlPolicy.getStlObjectId());
        stlBillData.setStlElementId(stlPolicy.getStlElementId());
        stlBillData.setStlElementSn(stlElementSn);
        stlBillData.setBillStyleSn(stlPolicy.getBillStyleSn());
        stlBillData.setBillTimeSn(billTimeSn);
        stlBillData.setBillStartTime(billStartTime);
        stlBillData.setBillEndTime(billEndTime);
        stlBillData.setOrigFee((float) origFee);
        stlBillData.setCreateTime(sysdate);
        stlBillData.setCreateDeptId(request.getOptDeptId());
        stlBillData.setCreateOperId(request.getOptOperId());
        stlBillData.setYyyyMm(StringUtil.restrictLength(request.getBillTimeSn(), 6));
        MapperFactory.getStlBillDataMapper().insert(stlBillData);
        return billId;
    }

    private void writeBillItemData(BillDetailDataImportRequest request, Timestamp sysdate,
            Long billId, Entry<String, Long> entry) {
        Long billItemId = SmcSeqUtil.createBillItemId();
        StlBillItemData stlBillItemData = new StlBillItemData();
        stlBillItemData.setBillItemId(billItemId);
        stlBillItemData.setBillId(billId);
        stlBillItemData.setTenantId(request.getTenantId());
        stlBillItemData.setItemType(SmcConstants.StlBillItemData.ItemType.NORMAL);
        stlBillItemData.setFeeItemId(entry.getKey());
        stlBillItemData.setTotalFee(entry.getValue().floatValue());
        stlBillItemData.setCreateTime(sysdate);
        stlBillItemData.setCreateDeptId(request.getOptDeptId());
        stlBillItemData.setCreateOperId(request.getOptOperId());
        stlBillItemData.setYyyyMm(request.getBillTimeSn());
        MapperFactory.getStlBillItemDataMapper().insert(stlBillItemData);
    }

    private StlImportLog writeImportLog(BillDetailDataImportRequest request, Timestamp sysdate,
            String state, String stateDesc, String batchNo) {
        Long logId = SmcSeqUtil.createLogId();
        StlImportLog stlImportLog = new StlImportLog();
        stlImportLog.setLogId(logId);
        stlImportLog.setTenantId(request.getTenantId());
        stlImportLog.setImpFileName(request.getImpFileName());
        stlImportLog.setImpFileUrl(request.getImpFileUrl());
        stlImportLog.setDataType(SmcConstants.StlImportLog.DataType.BILL);
        stlImportLog.setObjectId(request.getObjectId());
        stlImportLog.setBillTimeSn(request.getBillTimeSn());
        stlImportLog.setImportTime(sysdate);
        stlImportLog.setImportRecords(0L);
        stlImportLog.setBatchNo(batchNo);
        stlImportLog.setState(state);
        stlImportLog.setStateDesc(stateDesc);
        stlImportLog.setOptDeptId(request.getOptDeptId());
        stlImportLog.setOptOperId(request.getOptOperId());
        stlImportLog.setStateChgTime(sysdate);
        MapperFactory.getStlImportLogMapper().insert(stlImportLog);
        return stlImportLog;
    }

    private void deleteLocalTmpFile(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteLocalTmpFile(f);
            }
        }
        file.delete();
    }

    private void checkData(String batchNo, String stlElementSn, String policyCode,
            String billTimeSn, Timestamp billStartTime, Timestamp billEndTime) {
        if (StringUtil.isBlank(stlElementSn)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "结算方为空");
        }
        if (StringUtil.isBlank(batchNo)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "批次号为空");
        }
        if (StringUtil.isBlank(policyCode)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "政策编码为空");
        }
        if (StringUtil.isBlank(billTimeSn)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "账期为空");
        }
        if (billStartTime == null) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "账单开始时间为空");
        }
        if (billEndTime == null) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "账单结束时间为空");
        }
    }

    private StlPolicy getStlPolicy(String tenantId, String policyCode) {
        StlPolicyCriteria stlPolicyCriteria = new StlPolicyCriteria();
        stlPolicyCriteria.createCriteria().andTenantIdEqualTo(tenantId)
                .andPolicyCodeEqualTo(policyCode)
                .andStateEqualTo(SmcConstants.StlPolicy.State.NORMAL);
        List<StlPolicy> stlPolicies = MapperFactory.getStlPolicyMapper().selectByExample(
                stlPolicyCriteria);
        if (CollectionUtil.isEmpty(stlPolicies)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "政策编码["
                    + policyCode + "]信息不存在");
        }

        StlPolicy stlPolicy = stlPolicies.get(0);
        return stlPolicy;
    }

    private void checkBatchNo(String tenantId, String batchNo) {
        if (importLogAtomSV.isExistBatchNo(tenantId, batchNo)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "该批次号[" + batchNo
                    + "]文件已导入");
        }
    }

    private void checkTotalFee(long origFee, Map<String, Long> feeItemMap) {
        long totalFee = 0;
        for (Entry<String, Long> entry : feeItemMap.entrySet()) {
            totalFee += entry.getValue();
        }
        if (origFee != totalFee) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "总金额不一致");
        }
    }

    private String getBillFileIn(String saveFile) {
        File file = new File(saveFile);
        if (null != file) {
            for (File fileTmp : file.listFiles()) {
                if (fileTmp.isDirectory()) {
                    continue;
                }
                if (fileTmp.getName().endsWith(".xlsx") || fileTmp.getName().endsWith(".xls")) {
                    return fileTmp.getAbsolutePath();
                }
            }
        }
        return "";
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

    @Override
    public BaseResponse startSettlementCheck(SettlementCheckStartRequest request) {
        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        BaseResponse response = new BaseResponse();
        response.setResponseHeader(responseHeader);
        // 解析参数
        String tenantId = request.getTenantId();
        // 根据租户ID和批次号，从账单表获得本批次的第三方账单数据。
        StlBillData importBillData = getImportBillData(request);
        List<StlBillItemData> importBillItemDatas = getImportBillItemData(request, importBillData);
        // 根据第三方账单数据信息，查询对应的内部生成的账单数据（根据租户ＩＤ、政策编码、账期、具体结算方、账单来源＝sys 查询）
        StlBillData sysBillData = getSysBillData(request, importBillData);
        // 调用账单级对账程序（2.3.1.2）进行账单级对账。
        //  账单级对账逻辑（以第三方详单数据为基础进行比对）
        // 1， 根据第三方账单的租户、政策编码、结算账期、结算方加载本系统结算算费结果帐单数据（stl_bill_ data_yyyymm
        // ,stl_bill_item_data_yyyymm）;
        List<StlBillItemData> sysBillItemDatas = getSysBillItemData(request, sysBillData);

        // 2,按科目对原始金额进行比较,如果科目存在且金额一致,则标记录此科目对账成功,更新账单数据表中的对账状态(第三方账单和本系统结算算费结果帐单都要更新);
        // 如果科目不存在或金额不一致,则标识此科目对账不成功并记录差异金额.
        Timestamp sysdate = DateUtil.getSysDate();
        float billDiffFee = 0;
        for (StlBillItemData importBillItemData : importBillItemDatas) {
            boolean isExistSysItemData = false;
            for (StlBillItemData sysBillItemData : sysBillItemDatas) {
                if (importBillItemData.getFeeItemId().equals(sysBillItemData.getFeeItemId())) {
                    isExistSysItemData = true;
                    float diffFee = importBillItemData.getTotalFee()
                            - sysBillItemData.getTotalFee();
                    if (diffFee == 0) {
                        // 对账一致,记录对账结果
                        updateBillItemDataCheckState(request, sysdate, importBillItemData, diffFee,
                                SmcConstants.StlBillItemData.CheckState.UNANIMOUS,
                                SmcConstants.StlBillItemData.CheckStateDesc.UNANIMOUS);
                        updateBillItemDataCheckState(request, sysdate, sysBillItemData, diffFee,
                                SmcConstants.StlBillItemData.CheckState.UNANIMOUS,
                                SmcConstants.StlBillItemData.CheckStateDesc.UNANIMOUS);
                    } else {
                        // 金额不一致
                        billDiffFee += Math.abs(diffFee);
                        updateBillItemDataCheckState(request, sysdate, importBillItemData, diffFee,
                                SmcConstants.StlBillItemData.CheckState.INCONFORMITY,
                                SmcConstants.StlBillItemData.CheckStateDesc.INCONFORMITY);
                        updateBillItemDataCheckState(request, sysdate, sysBillItemData, -diffFee,
                                SmcConstants.StlBillItemData.CheckState.INCONFORMITY,
                                SmcConstants.StlBillItemData.CheckStateDesc.INCONFORMITY);
                    }
                    break;
                }
            }
            if (!isExistSysItemData) {
                // 第三方存在此科目，内部生成不存在此科目
                billDiffFee += Math.abs(importBillItemData.getTotalFee());
                updateBillItemDataCheckState(request, sysdate, importBillItemData,
                        importBillItemData.getTotalFee(),
                        SmcConstants.StlBillItemData.CheckState.INCONFORMITY,
                        SmcConstants.StlBillItemData.CheckStateDesc.INCONFORMITY);
            }
        }
        for (StlBillItemData sysBillItemData : sysBillItemDatas) {
            boolean isExistImportItemData = false;
            for (StlBillItemData importBillItemData : importBillItemDatas) {
                if (importBillItemData.getFeeItemId().equals(sysBillItemData.getFeeItemId())) {
                    isExistImportItemData = true;
                    break;
                }
            }
            if (!isExistImportItemData) {
                // 第三方不存在此科目，内部生成存在此科目
                billDiffFee += Math.abs(sysBillItemData.getTotalFee());
                updateBillItemDataCheckState(request, sysdate, sysBillItemData,
                        sysBillItemData.getTotalFee(),
                        SmcConstants.StlBillItemData.CheckState.INCONFORMITY,
                        SmcConstants.StlBillItemData.CheckStateDesc.INCONFORMITY);
            }
        }
        // 3， 汇总各科目的差异金额（取绝对值累加），更新账单数据表（第三方账单和本系统结算算费结果帐单都要更新）中的差异金额及对账结果。
        String billDataCheckState;
        String billDataCheckStateDesc;
        if (billDiffFee == 0) {
            billDataCheckState = SmcConstants.StlBillData.CheckState.UNANIMOUS;
            billDataCheckStateDesc = SmcConstants.StlBillData.CheckStateDesc.BILL_UNANIMOUS;
        } else {
            billDataCheckState = SmcConstants.StlBillData.CheckState.INCONFORMITY;
            billDataCheckStateDesc = SmcConstants.StlBillData.CheckStateDesc.HAS_DIFFERENCE;
        }
        updateBillDataCheckState(request, sysBillData, sysdate, billDiffFee, billDataCheckState,
                billDataCheckStateDesc);
        updateBillDataCheckState(request, importBillData, sysdate, billDiffFee, billDataCheckState,
                billDataCheckStateDesc);
        // 查询导入日志
        StlImportLog stlImportLog = getImportLog(request);
        // 如果对账无差异，则对账完成。
        if (SmcConstants.StlBillData.CheckState.UNANIMOUS.equals(billDataCheckState)) {
            // 更新导入日志状态为数据处理完成
            stlImportLog.setState(SmcConstants.StlImportLog.State.DATA_SUCCESS);
            stlImportLog.setStateDesc(SmcConstants.StlImportLog.StateDesc.DATA_SUCCESS);
            stlImportLog.setStateChgTime(sysdate);
            MapperFactory.getStlImportLogMapper().updateByPrimaryKey(stlImportLog);
            return response;
        }
        // 如果有差异，则根据数据导入日志表中的文件存放地址信息，解析每个详单文件，获取批次号和总数量。
        String impFileUrl = stlImportLog.getImpFileUrl();
        /* 1 下载压缩包到本地 */
        String saveFile = downFile(impFileUrl, stlImportLog.getImpFileName(), tenantId);
        // 校验csv文件编码是否是utf-8
        checkZipFileEncode(saveFile);
        try {
            List<File> billDetailFileList = new ArrayList<File>();
            for (File filetmp : new File(saveFile.substring(0, saveFile.lastIndexOf(".")))
                    .listFiles()) {
                if (filetmp.isDirectory()) {
                    continue;
                }
                String filetmpName = filetmp.getName();
                LOGGER.info(filetmpName);
                if (filetmpName.endsWith(".csv") || filetmpName.endsWith(".txt")) {
                    billDetailFileList.add(filetmp);
                }
            }
            // 校验所有文件的批次号是否相同，如果不相同则本次导入文件异常，记录异常原因（数据导入日志表）并直接返回。
            // 累计每个文件的业务流水记录数（第三行开始计数），如果合计与文件首行的记录数不一致，则本次导入文件异常，记录异常原因（数据导入日志表）并直接返回。
            String batchNo = request.getBatchNo();
            for (File billDetailFile : billDetailFileList) {
                BufferedReader bufferedReader = null;
                try {
                    InputStream inputStream = new FileInputStream(billDetailFile);
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
                            SmcConstants.CHARSET_UTF8);
                    bufferedReader = new BufferedReader(inputStreamReader);
                    String[] headerLine;
                    if (billDetailFile.getName().endsWith(".csv")) {
                        headerLine = bufferedReader.readLine().split(",");
                    } else {
                        headerLine = bufferedReader.readLine().split(SmcConstants.FIELD_SPLIT);
                    }
                    String batchNoTmp = headerLine[1];
                    String thisRecord = headerLine[5];
                    LOGGER.error(" ====== thisRecord = " + thisRecord);
                    if (!batchNo.equals(batchNoTmp)) {
                        throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "文件["
                                + billDetailFile.getName() + "]批次号不一致");
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
                                + billDetailFile.getName() + "]记录数不一致");
                    }
                } catch (BusinessException busiE) {
                    LOGGER.error("failure", busiE);
                    stlImportLog.setState(SmcConstants.StlImportLog.State.EXCEPTION);
                    stlImportLog.setStateDesc(busiE.getErrorMessage());
                    MapperFactory.getStlImportLogMapper().updateByPrimaryKey(stlImportLog);
                    responseHeader.setSuccess(false);
                    responseHeader.setResultCode(busiE.getErrorCode());
                    responseHeader.setResultMessage(busiE.getErrorMessage());
                    return response;
                } finally {
                    if(null != bufferedReader){
                        bufferedReader.close();
                    }
                }

            }
            String importRecords = "";
            String jSBsn = "JS" + tenantId + batchNo;
            String address = SysParamUtil
                    .getSysParams(request.getTenantId(), TypeCode.DATA_COLLECT, ParamCode.URL)
                    .get(0).getColumnValue();
            // 从每个文第三行开始读取每个文件的详单数据，把批次号和总数量拼到流水头部，调用采集模块的标接口接口输入详单数据。
            for (File billDetailFile : billDetailFileList) {
                InputStream inputStream = new FileInputStream(billDetailFile);

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
                        SmcConstants.CHARSET_UTF8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                
                String aLine = bufferedReader.readLine();
                if (StringUtil.isBlank(aLine)) {
                    LOGGER.info("[" + billDetailFile.getName() + "]的首行是空的，继续下一个文件");
                    continue;
                }
                
                String[] headerLine;
                if (billDetailFile.getName().endsWith(".csv")) {
                    headerLine = aLine.split(",");
                } else {
                    headerLine = aLine.split(SmcConstants.FIELD_SPLIT);
                }
                importRecords = headerLine[3];
                bufferedReader.readLine();
                // 消息头
                String userId = SysParamUtil
                        .getSysParams(request.getTenantId(), TypeCode.AUTH, ParamCode.USER_ID)
                        .get(0).getColumnValue();
                String passwd = SysParamUtil
                        .getSysParams(request.getTenantId(), TypeCode.AUTH, ParamCode.PAASWD)
                        .get(0).getColumnValue();
                String header = new StringBuilder().append(tenantId)
                        .append(SmcConstants.HEADER_SPLIT).append(stlImportLog.getObjectId())
                        .append("-detail").append(SmcConstants.HEADER_SPLIT).append(batchNo)
                        .append(SmcConstants.HEADER_SPLIT).append(userId)
                        .append(SmcConstants.HEADER_SPLIT).append(passwd)
                        .append(SmcConstants.HEADER_SPLIT).toString();

                while (true) {
                    String line = bufferedReader.readLine();
                    if (StringUtil.isBlank(line)) {
                        break;
                    }
                    if (billDetailFile.getName().endsWith(".csv")) {
                        line = line.replaceAll(SmcConstants.CVSFILE_FEILD_SPLIT,
                                SmcConstants.FIELD_SPLIT);
                        // LOG.error("line = " + line);
                    }
                    String message = new StringBuilder(header).append(stlImportLog.getObjectId())
                            .append("-detail").append(SmcConstants.FIELD_SPLIT).append(batchNo)
                            .append(SmcConstants.FIELD_SPLIT).append(importRecords)
                            .append(SmcConstants.FIELD_SPLIT).append(line).toString();
                    JsDataVO dataVO = new JsDataVO();
                    dataVO.setMessage(message);
                    dataVO.setjSBsn(jSBsn);
                    LOGGER.error(" ====== 调用采集服务:[" + JSON.toJSONString(dataVO) + "]");
                    HttpResponse httpResponse = HttpClientUtil.send(address,
                            JSON.toJSONString(dataVO));
                    LOGGER.info("httpResponse.getStatusLine() = " + httpResponse.getStatusLine());
                }
                bufferedReader.close();
            }
            // 批次发送完成，发送结束消息
            JsDataVO dataVO = new JsDataVO();
            dataVO.setjSBsn("JS0000");
            HttpClientUtil.send(address, JSON.toJSONString(dataVO));
            // 导入完成，更新数据导入日志表。
            stlImportLog.setState(SmcConstants.StlImportLog.State.DATA_PROCESSING);
            stlImportLog.setStateDesc(SmcConstants.StlImportLog.StateDesc.DATA_PROCESSING);
            stlImportLog.setImportRecords(Long.valueOf(importRecords));
            stlImportLog.setStateChgTime(sysdate);
            MapperFactory.getStlImportLogMapper().updateByPrimaryKey(stlImportLog);
        } catch (IOException e) {
            throw new SystemException(e);
        } finally {
            deleteLocalTmpFile(new File(saveFile.substring(0, saveFile.lastIndexOf("/"))));
        }
        return response;
    }

    private StlImportLog getImportLog(SettlementCheckStartRequest request) {
        StlImportLogCriteria stlImportLogCriteria = new StlImportLogCriteria();
        stlImportLogCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andBatchNoEqualTo(request.getBatchNo());
        List<StlImportLog> stlImportLogs = MapperFactory.getStlImportLogMapper().selectByExample(
                stlImportLogCriteria);
        if (CollectionUtil.isEmpty(stlImportLogs)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "批次号["
                    + request.getBatchNo() + "]数据导入日志不存在 ");
        }
        StlImportLog stlImportLog = stlImportLogs.get(0);
        return stlImportLog;
    }

    private List<StlBillItemData> getSysBillItemData(SettlementCheckStartRequest request,
            StlBillData sysBillData) {
        StlBillItemDataCriteria stlBillItemDataCriteria = new StlBillItemDataCriteria();
        stlBillItemDataCriteria.setYyyyMm(request.getBillMonth());
        stlBillItemDataCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andBillIdEqualTo(sysBillData.getBillId());
        List<StlBillItemData> sysBillItemDatas = MapperFactory.getStlBillItemDataMapper()
                .selectByExample(stlBillItemDataCriteria);
        return sysBillItemDatas;
    }

    private StlBillData getSysBillData(SettlementCheckStartRequest request,
            StlBillData importBillData) {
        StlBillDataCriteria stlBillDataCriteria = new StlBillDataCriteria();
        stlBillDataCriteria.setOrderByClause(" create_time desc ");
        stlBillDataCriteria.setYyyyMm(request.getBillMonth());
        stlBillDataCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andPolicyCodeEqualTo(importBillData.getPolicyCode())
                .andBillTimeSnEqualTo(importBillData.getBillTimeSn())
                .andStlElementSnEqualTo(importBillData.getStlElementSn())
                .andBillFromEqualTo(SmcConstants.StlBillData.BillFrom.SYS);
        List<StlBillData> stlBillDatas = MapperFactory.getStlBillDataMapper().selectByExample(
                stlBillDataCriteria);
        // 如果查询不到对应的内部生成的账单数据，则说明内部账单未生成，返回异常。
        if (CollectionUtil.isEmpty(stlBillDatas)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "内部生成的账单不存在");
        }
        StlBillData sysBillData = stlBillDatas.get(0);
        return sysBillData;
    }

    private List<StlBillItemData> getImportBillItemData(SettlementCheckStartRequest request,
            StlBillData importBillData) {
        List<StlBillItemData> importBillItemDatas = getSysBillItemData(request, importBillData);
        return importBillItemDatas;
    }

    private StlBillData getImportBillData(SettlementCheckStartRequest request) {
        StlBillDataCriteria stlBillDataCriteria = new StlBillDataCriteria();
        stlBillDataCriteria.setYyyyMm(request.getBillMonth());
        stlBillDataCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andBatchNoEqualTo(request.getBatchNo());
        List<StlBillData> stlBillDatas = MapperFactory.getStlBillDataMapper().selectByExample(
                stlBillDataCriteria);
        if (CollectionUtil.isEmpty(stlBillDatas)) {
            throw new BusinessException(SmcExceptCodeConstant.BUSINESS_EXCEPTION, "第三方账单不存在");
        }
        StlBillData importBillData = stlBillDatas.get(0);
        return importBillData;
    }

    private void updateBillDataCheckState(SettlementCheckStartRequest request,
            StlBillData stlBillData, Timestamp sysdate, float billDiffFee, String checkState,
            String checkStateDesc) {
        stlBillData.setCheckState(checkState);
        stlBillData.setCheckStateDesc(checkStateDesc);
        stlBillData.setCheckTime(sysdate);
        stlBillData.setDiffFee(billDiffFee);
        stlBillData.setYyyyMm(request.getBillMonth());
        MapperFactory.getStlBillDataMapper().updateByPrimaryKey(stlBillData);
    }

    private void updateBillItemDataCheckState(SettlementCheckStartRequest request,
            Timestamp sysdate, StlBillItemData stlBillItemData, float diffFee, String checkState,
            String checkStateDesc) {
        stlBillItemData.setCheckState(checkState);
        stlBillItemData.setDiffFee(diffFee);
        stlBillItemData.setCheckStateDesc(checkStateDesc);
        stlBillItemData.setCheckTime(sysdate);
        stlBillItemData.setYyyyMm(request.getBillMonth());
        MapperFactory.getStlBillItemDataMapper().updateByPrimaryKey(stlBillItemData);
    }

    @Override
    public CheckResultQueryResponse queryCheckResult(CheckResultQueryRequest request) {
        ResponseHeader responseHeader = new ResponseHeader(true, SmcExceptCodeConstant.SUCCESS,
                "成功");
        CheckResultQueryResponse response = new CheckResultQueryResponse();
        response.setResponseHeader(responseHeader);
        StlBillDataCriteria stlBillDataCriteria = new StlBillDataCriteria();
        stlBillDataCriteria.setYyyyMm(request.getBillMonth());
        stlBillDataCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andBillIdEqualTo(request.getBillId());
        List<StlBillData> stlBillDatas = MapperFactory.getStlBillDataMapper().selectByExample(
                stlBillDataCriteria);
        if (CollectionUtil.isEmpty(stlBillDatas)) {
            return response;
        }
        StlBillData stlBillData = stlBillDatas.get(0);
        BeanUtils.copyVO(response, stlBillData);
        response.setBillStartTimeStr(DateUtil.getDateString(stlBillData.getBillStartTime(),
                DateUtil.YYYYMMDD));
        response.setBillEndTimeStr(DateUtil.getDateString(stlBillData.getBillEndTime(),
                DateUtil.YYYYMMDD));
        response.setCreateTimeStr(DateUtil.getDateString(stlBillData.getCreateTime(),
                DateUtil.YYYYMMDD));

        StlBillItemDataCriteria stlBillItemDataCriteria = new StlBillItemDataCriteria();
        stlBillItemDataCriteria.setYyyyMm(request.getBillMonth());
        stlBillItemDataCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                .andBillIdEqualTo(request.getBillId());
        List<StlBillItemData> stlBillItemDatas = MapperFactory.getStlBillItemDataMapper()
                .selectByExample(stlBillItemDataCriteria);
        if (!CollectionUtil.isEmpty(stlBillItemDatas)) {
            List<FeeItemData> feeItemDatas = new ArrayList<FeeItemData>();
            for (StlBillItemData stlBillItemData : stlBillItemDatas) {
                FeeItemData feeItemData = new FeeItemData();
                feeItemData.setFeeItemId(stlBillItemData.getFeeItemId());
                feeItemData.setFeeItemName(SysParamUtil.getSysParamDesc(request.getTenantId(),
                        TypeCode.STL_POLICY_ITEM_PLAN, ParamCode.FEE_ITEM,
                        stlBillItemData.getFeeItemId()));
                feeItemData.setDiffFee(stlBillItemData.getDiffFee());
                feeItemData.setTotalFee(stlBillItemData.getTotalFee());
                feeItemDatas.add(feeItemData);
            }
            response.setFeeItemDatas(feeItemDatas);
        }

        return response;
    }

    @Override
    public HBasePager<DiffDetailDataInfo> queryCheckResultDiffDetail(
            CheckResultDiffDetailQueryRequest request) {
        HBasePager<DiffDetailDataInfo> pager = request.getPager();
        // 不分页
        if (pager == null) {
            pager = new HBasePager<DiffDetailDataInfo>();
            // 查询账单信息
            StlBillDataCriteria stlBillDataCriteria = new StlBillDataCriteria();
            stlBillDataCriteria.setYyyyMm(request.getBillMonth());
            stlBillDataCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                    .andBillIdEqualTo(request.getBillId());
            List<StlBillData> stlBillDatas = MapperFactory.getStlBillDataMapper().selectByExample(
                    stlBillDataCriteria);
            if (CollectionUtil.isEmpty(stlBillDatas)) {
                pager.setPageSize(10);
                return pager;
            }

            StlBillData stlBillData = stlBillDatas.get(0);
            // 查询详单项配置
            StringBuilder keyStringBuilder = new StringBuilder();
            keyStringBuilder.append(request.getTenantId()).append(SmcCacheConstant.CACHE_KEY_SPLIT)
                    .append(stlBillData.getBillStyleSn()).append(SmcCacheConstant.CACHE_KEY_SPLIT)
                    .append(SmcCacheConstant.BILL_DETAIL_ITEM);
            String cacheStr = RedisUtil.getCacheClient().hget(
                    SmcCacheConstant.NameSpace.BILL_STYLE_CACHE, keyStringBuilder.toString());
            if (StringUtil.isBlank(cacheStr)) {
                throw new SystemException("账单样式编码[" + stlBillData.getBillStyleSn() + "]详单项配置不存在");
            }
            List<StlBillStyleItem> stlBillStyleItems = JSON.parseArray(cacheStr,
                    StlBillStyleItem.class);
            Map<String, Object> billDetailItemMap = new HashMap<String, Object>();
            for (StlBillStyleItem stlBillStyleItem : stlBillStyleItems) {
                if (!billDetailItemMap.containsKey(stlBillStyleItem.getItemCode())) {
                    billDetailItemMap.put(stlBillStyleItem.getItemCode(), null);
                }
            }

            StringBuilder rowKeyStringBuilder = new StringBuilder();
            rowKeyStringBuilder.append(request.getTenantId()).append(SmcHbaseConstant.ROWKEY_SPLIT)
                    .append(request.getBillId()).append(SmcHbaseConstant.ROWKEY_SPLIT)
                    .append(stlBillData.getBillTimeSn()).append(SmcHbaseConstant.ROWKEY_SPLIT)
                    .append(stlBillData.getStlObjectId()).append(SmcHbaseConstant.ROWKEY_SPLIT)
                    .append(stlBillData.getBillFrom()).append(SmcHbaseConstant.ROWKEY_SPLIT);

            Connection conn = HbaseClient.getInstance().getConnection();
            Table table;
            try {
                table = conn.getTable(TableName
                        .valueOf(SmcHbaseConstant.TableName.STL_BILL_DETAIL_DIFF_DATA));
            } catch (IOException e) {
                throw new SystemException(e);
            }

            Filter filter = new RowFilter(CompareOp.EQUAL, new BinaryPrefixComparator(
                    rowKeyStringBuilder.toString().getBytes()));
            PageFilter pageFilter = new PageFilter(500);// 不分页时只返回500条
            FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
            filterList.addFilter(filter);
            filterList.addFilter(pageFilter);
            Scan scan = new Scan();
            scan.setFilter(filter);
            ResultScanner rs;
            try {
                rs = table.getScanner(scan);
            } catch (IOException e) {
                throw new SystemException(e);
            }
            List<DiffDetailDataInfo> diffDetailDataInfos = new ArrayList<DiffDetailDataInfo>();
            for (Result rt : rs) {
                DiffDetailDataInfo diffDetailDataInfo = new DiffDetailDataInfo();
                diffDetailDataInfo.setRowKey(new String(rt.getRow()));
                diffDetailDataInfo.setBillId(request.getBillId());
                diffDetailDataInfo.setTenantId(request.getTenantId());
                Map<String, String> mapTmp = new HashMap<String, String>();
                NavigableMap<byte[], byte[]> navigableMap = rt
                        .getFamilyMap(SmcHbaseConstant.FamilyName.COLUMN_DEF.getBytes());
                try {
                    for (Entry<String, Object> entry : billDetailItemMap.entrySet()) {
                        String value = new String(navigableMap.get(entry.getKey().getBytes("UTF-8")), "UTF-8");
                        mapTmp.put(entry.getKey(), value);
                    }
                } catch (UnsupportedEncodingException e) {
                    throw new BusinessException(e);
                }
                diffDetailDataInfo.setData(JSON.toJSONString(mapTmp));
            }

            pager.setPageSize(diffDetailDataInfos.size() == 0 ? 10 : diffDetailDataInfos.size());
            pager.setResult(diffDetailDataInfos);
        } else {
            // 分页查询
            // 查询账单信息
            StlBillDataCriteria stlBillDataCriteria = new StlBillDataCriteria();
            stlBillDataCriteria.setYyyyMm(request.getBillMonth());
            stlBillDataCriteria.createCriteria().andTenantIdEqualTo(request.getTenantId())
                    .andBillIdEqualTo(request.getBillId());
            List<StlBillData> stlBillDatas = MapperFactory.getStlBillDataMapper().selectByExample(
                    stlBillDataCriteria);
            if (CollectionUtil.isEmpty(stlBillDatas)) {
                return pager;
            }

            StlBillData stlBillData = stlBillDatas.get(0);
            // 查询详单项配置
            StringBuilder keyStringBuilder = new StringBuilder();
            keyStringBuilder.append(request.getTenantId()).append(SmcCacheConstant.CACHE_KEY_SPLIT)
                    .append(stlBillData.getBillStyleSn()).append(SmcCacheConstant.CACHE_KEY_SPLIT)
                    .append(SmcCacheConstant.BILL_DETAIL_ITEM);
            String cacheStr = RedisUtil.getCacheClient().hget(
                    SmcCacheConstant.NameSpace.BILL_STYLE_CACHE, keyStringBuilder.toString());
            if (StringUtil.isBlank(cacheStr)) {
                throw new SystemException("账单样式编码[" + stlBillData.getBillStyleSn() + "]详单项配置不存在");
            }
            List<StlBillStyleItem> stlBillStyleItems = JSON.parseArray(cacheStr,
                    StlBillStyleItem.class);
            Map<String, Object> billDetailItemMap = new HashMap<String, Object>();
            for (StlBillStyleItem stlBillStyleItem : stlBillStyleItems) {
                if (!billDetailItemMap.containsKey(stlBillStyleItem.getItemCode())) {
                    billDetailItemMap.put(stlBillStyleItem.getItemCode(), null);
                }
            }

            StringBuilder rowKeyStringBuilder = new StringBuilder();
            rowKeyStringBuilder.append(request.getTenantId()).append(SmcHbaseConstant.ROWKEY_SPLIT)
                    .append(request.getBillId()).append(SmcHbaseConstant.ROWKEY_SPLIT)
                    .append(stlBillData.getBillTimeSn()).append(SmcHbaseConstant.ROWKEY_SPLIT)
                    .append(stlBillData.getStlObjectId()).append(SmcHbaseConstant.ROWKEY_SPLIT)
                    .append(stlBillData.getBillFrom()).append(SmcHbaseConstant.ROWKEY_SPLIT);

            Connection conn = HbaseClient.getInstance().getConnection();
            Table table;
            try {
                table = conn.getTable(TableName
                        .valueOf(SmcHbaseConstant.TableName.STL_BILL_DETAIL_DIFF_DATA));
            } catch (IOException e) {
                throw new SystemException(e);
            }
            FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
            Filter filter = new RowFilter(CompareOp.EQUAL, new BinaryPrefixComparator(
                    rowKeyStringBuilder.toString().getBytes()));
            filterList.addFilter(filter);
            Scan scan = new Scan();
            // 查询第一页
            if (StringUtil.isBlank(pager.getStartRow())
                    && StringUtil.isBlank(pager.getPreviousRow())) {
                PageFilter pageFilter = new PageFilter(pager.getPageSize());
                filterList.addFilter(pageFilter);
            } else
            // 向后查一页
            if (StringUtil.isBlank(pager.getStartRow())
                    && !StringUtil.isBlank(pager.getPreviousRow())) {
                PageFilter pageFilter = new PageFilter(pager.getPageSize() + 1);
                filterList.addFilter(pageFilter);
                scan.setStartRow(pager.getPreviousRow().getBytes());
            } else
            // 向前查一页
            if (!StringUtil.isBlank(pager.getStartRow())) {
                PageFilter pageFilter = new PageFilter(pager.getPageSize());
                filterList.addFilter(pageFilter);
                scan.setStartRow(pager.getStartRow().getBytes());
            } else {
                throw new BusinessException(SmcExceptCodeConstant.PARAM_IS_NULL, "分页器参数不合法");
            }
            scan.setFilter(filterList);
            ResultScanner rs;
            try {
                rs = table.getScanner(scan);
            } catch (IOException e) {
                throw new SystemException(e);
            }
            List<DiffDetailDataInfo> diffDetailDataInfos = new ArrayList<DiffDetailDataInfo>();
            int i = 0;
            for (Result rt : rs) {
                if (i == 0 && StringUtil.isBlank(pager.getStartRow())
                        && !StringUtil.isBlank(pager.getPreviousRow())) {
                    i++;
                    continue;
                }
                i++;
                DiffDetailDataInfo diffDetailDataInfo = new DiffDetailDataInfo();
                diffDetailDataInfo.setRowKey(new String(rt.getRow()));
                diffDetailDataInfo.setBillId(request.getBillId());
                diffDetailDataInfo.setTenantId(request.getTenantId());
                Map<String, String> mapTmp = new HashMap<String, String>();
                NavigableMap<byte[], byte[]> navigableMap = rt
                        .getFamilyMap(SmcHbaseConstant.FamilyName.COLUMN_DEF.getBytes());
                for (Entry<String, Object> entry : billDetailItemMap.entrySet()) {
                    String value = new String(navigableMap.get(entry.getKey()));
                    mapTmp.put(entry.getKey(), value);
                }
                diffDetailDataInfo.setData(JSON.toJSONString(mapTmp));
            }

            pager.setPageSize(diffDetailDataInfos.size() == 0 ? 10 : diffDetailDataInfos.size());
            pager.setResult(diffDetailDataInfos);
        }

        return pager;
    }

}
