package com.x.ic.smc.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import com.x.base.exception.SystemException;


public final class AntZipUtil {
    private AntZipUtil() {
    }

    private static final Logger LOGGER = LogManager.getLogger(AntZipUtil.class);

    public static void unzip(String zipFilePath, String targetPath) {
        OutputStream os = null;
        InputStream is = null;
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(zipFilePath);
            String directoryPath = "";
            if (null == targetPath || "".equals(targetPath)) {
                directoryPath = zipFilePath.substring(0, zipFilePath.lastIndexOf('.'));
            } else {
                directoryPath = targetPath;
            }
            Enumeration<ZipEntry> entryEnum = zipFile.getEntries();
            if (null != entryEnum) {
                ZipEntry zipEntry = null;
                while (entryEnum.hasMoreElements()) {
                    zipEntry = (ZipEntry) entryEnum.nextElement();
                    if (zipEntry.isDirectory()) {
                        // directoryPath = directoryPath + File.separator + zipEntry.getName();
                        LOGGER.info(directoryPath);
                        continue;
                    }
                    if (zipEntry.getSize() > 0) {
                        // 文件
                        File targetFile = buildFile(
                                directoryPath + File.separator + zipEntry.getName(), false);
                        os = new BufferedOutputStream(new FileOutputStream(targetFile));
                        is = zipFile.getInputStream(zipEntry);
                        byte[] buffer = new byte[4096];
                        int readLen = 0;
                        while ((readLen = is.read(buffer, 0, 4096)) >= 0) {
                            os.write(buffer, 0, readLen);
                        }

                        os.flush();
                        os.close();
                    } else {
                        // 空目录
                        buildFile(directoryPath + File.separator + zipEntry.getName(), true);
                    }
                }
            }
        } catch (IOException ex) {
            throw new SystemException(ex);
        } finally {
            if (null != zipFile) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    LOGGER.error(e);
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error(e);
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    /**
     * 生产文件 如果文件所在路径不存在则生成路径
     * 
     * @param fileName
     *            文件名 带路径
     * @param isDirectory
     *            是否为路径
     * @return
     * @author yayagepei
     * @date 2008-8-27
     */
    static File buildFile(String fileName, boolean isDirectory) {
        File target = new File(fileName);
        if (isDirectory) {
            if (!target.mkdirs()) {
                throw new SystemException("创建目录失败[" + target.getName() + "]");
            }
        } else {
            if (!target.getParentFile().exists()) {
                target.getParentFile().mkdirs();
                target = new File(target.getAbsolutePath());
            }
        }
        return target;
    }
}
