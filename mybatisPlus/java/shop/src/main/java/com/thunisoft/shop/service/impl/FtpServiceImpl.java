/*
 * @(#)FtpStorageServiceImpl.java 2017-9-11上午10:13:05 shop Copyright 2017
 * Thuisoft, Inc. All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use
 * is subject to license terms.
 */
package com.thunisoft.shop.service.impl;

import com.thunisoft.shop.domain.ftp.FtpConfig;
import com.thunisoft.shop.service.IFtpService;
import com.thunisoft.shop.utils.StringUtil;
import com.thunisoft.shop.utils.ftppool.FileUtil;
import com.thunisoft.shop.utils.ftppool.FtpClientPool;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author ljw on 2017-9-11上午10:13:05
 */
@Service("ftpService")
public class FtpServiceImpl implements IFtpService {

    /** 日志组件. */
    private static final Logger logger = LoggerFactory
            .getLogger(FtpServiceImpl.class);

    /**缩略图的宽*/
    private static final Integer IMGWIDTH = 300;

    /**缩略图的高*/
    private static final Integer IMGHEIGHT = 224;

    /**
     * 上传文件,上传后自动生成随机文件名
     * @param file  文件
     * @param ftpClient ftp客户端
     * @return  文件存储地址+文件名
     * @throws Exception 异常
     */
    @Override
    public String upLoadFile(File file, FTPClient ftpClient) throws Exception {
        String ext = FileUtil.getLowerCaseExtName(file);
        if (StringUtils.isBlank(ext)) {
            logger.error("上传文件没有后缀名！");
            return null;
        }
        String fileName = StringUtil.getUuid() + "." + ext;
        return upLoadFile(file, fileName, ftpClient);
    }

    /**
     * 上传文件,上传后自动生成随机文件名,针对file为临时文件情况
     * @param file  临时文件（xx.tmp）
     * @param ftpClient ftp客户端
     * @param realFileName 真实文件名
     * @return  文件存储地址+文件名
     * @throws Exception 异常
     */
    @Override
    public String upLoadTmpFile(File file, String realFileName,
            FTPClient ftpClient) throws Exception {
        String ext = FilenameUtils.getExtension(realFileName);
        if (StringUtils.isBlank(ext)) {
            logger.error("上传文件没有后缀名！");
            return null;
        }
        String fileName = StringUtil.getUuid() + "." + ext;
        return upLoadFile(file, fileName, ftpClient);
    }

    /**
     * 生成缩略图并上载
     * @param file 文件
     * @param bigFilePathAndName 大图的路径和名字
     * @param ftpClient ftp客户端
     * @return String
     * @throws Exception 异常
     */
    @Override
    public String uploadSmallFile(File file, String bigFilePathAndName,
            FTPClient ftpClient) throws Exception {
        boolean createSmallFile = FtpClientPool.getFtpConfig()
                .isCreateSmallFile();
        if (!createSmallFile) {
            return null;
        }
        String baseName = FilenameUtils.getBaseName(bigFilePathAndName);
        String ext = FilenameUtils.getExtension(bigFilePathAndName);
        StringBuilder miniFileName = new StringBuilder(baseName)
                .append("_mini.").append(ext);

        //生产缩略图
        //按照比例进行缩放，转化图像格式，输出到OutputStream
        ByteArrayOutputStream step1 = new ByteArrayOutputStream();
        Thumbnails.of(file).scale(1f).outputFormat("jpg").toOutputStream(step1);

        //指定大小进行缩放，
        ByteArrayOutputStream step2 = new ByteArrayOutputStream();
        Thumbnails.of(new ByteArrayInputStream(step1.toByteArray()))
                .size(IMGWIDTH, IMGHEIGHT).toOutputStream(step2);

        //文件流
        InputStream inputStream = new ByteArrayInputStream(step2.toByteArray());
        return upLoadFile(inputStream, miniFileName.toString(), ftpClient);
    }

    /**
     * 上传文件,指定上传后的文件名（目标文件名）
     * @param file 文件
     * @param targetFileName 目标文件名
     * @param ftpClient ftp客户端
     * @return  文件存储地址+文件名
     * @throws Exception 异常
     */
    @Override
    public String upLoadFile(File file, String targetFileName,
            FTPClient ftpClient) throws Exception {
        boolean result = false;
        FileInputStream inputStream = new FileInputStream(file);
        String filePath = null;
        try {
            FtpConfig ftpConfig = FtpClientPool.getFtpConfig();
            String basePath = ftpConfig.getBasepath();
            filePath = basePath + File.separator + StringUtil.getYyrStr();

            String replDirPath = filePath.replace("\\", "/");
            //切换工作目录到根目录
            ftpClient.changeWorkingDirectory("/");
            boolean change = ftpClient.changeWorkingDirectory(filePath);
            if (!change) {
                String[] ftppaths = replDirPath.split("/");
                //将文件目录按路径分隔符读取，然后分别创建
                for (int i = 0; i < ftppaths.length; i++) {
                    String folder = ftppaths[i];
                    if (StringUtils.isNotBlank(folder)) {
                        ftpClient.makeDirectory(folder);
                        change = ftpClient.changeWorkingDirectory(folder);
                    }
                }
            }
            if (change) {
                result = ftpClient
                        .storeFile(
                            new String(targetFileName.getBytes(
                                ftpConfig.getEncoding()), "iso-8859-1"),
                            inputStream);
            }
            if (result) {
                logger.info("上传成功");
            } else {
                logger.error("上传失败");
            }
        } catch (IOException e) {
            throw new Exception(e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return result ? (filePath + File.separator + targetFileName) : null;
    }

    /**
     * 上传文件,指定上传后的文件名（目标文件名）
     * @param inputStream  文件输入流
     * @param targetFileName 目标文件名
     * @param ftpClient ftp客户端
     * @return  文件存储地址+文件名
     * @throws Exception 异常
     */
    @Override
    public String upLoadFile(InputStream inputStream, String targetFileName,
            FTPClient ftpClient) throws Exception {
        boolean result = false;
        FtpConfig ftpConfig = FtpClientPool.getFtpConfig();
        String basePath = ftpConfig.getBasepath();
        String filePath = basePath + File.separator + StringUtil.getYyrStr();

        String replDirPath = filePath.replace("\\", "/");
        //切换工作目录到根目录
        ftpClient.changeWorkingDirectory("/");
        boolean change = ftpClient.changeWorkingDirectory(filePath);
        if (!change) {
            String[] ftppaths = replDirPath.split("/");
            //将文件目录按路径分隔符读取，然后分别创建  
            for (int i = 0; i < ftppaths.length; i++) {
                String folder = ftppaths[i];
                if (StringUtils.isNotBlank(folder)) {
                    ftpClient.makeDirectory(folder);
                    change = ftpClient.changeWorkingDirectory(folder);
                }
            }
        }
        if (change) {
            result = ftpClient
                    .storeFile(
                        new String(targetFileName.getBytes(
                            ftpConfig.getEncoding()), "iso-8859-1"),
                        inputStream);
        }
        if (result) {
            logger.info("上传成功");
        } else {
            logger.error("上传失败");
        }
        IOUtils.closeQuietly(inputStream);
        return result ? (filePath + File.separator + targetFileName) : null;
    }

    /**
     * 下载文件,返回流，用户浏览器</br>
     * 调用者必须先关闭inputStream，再调用ftpClient.completePendingCommand();</br>
     * completePendingCommand()会一直在等FTP Server返回226 Transfer complete，</br>
     * 但是FTP Server只有在接受到InputStream执行close方法时，才会返回。所以先要执行close方法</br>
     * 如果没写ftpClient.completePendingCommand();会导致后面对FTPClient的操作都失败
     * @param filePathAndName  文件存储地址+文件名字
     * @param ftpClient ftp客户端
     * @return  文件流
     * @throws Exception 异常
     */
    @Override
    public InputStream downloadFile(String filePathAndName,
            FTPClient ftpClient) throws Exception {
        InputStream inputStream = null;
        String dirPath = FilenameUtils
                .getFullPathNoEndSeparator(filePathAndName);
        String fileName = FilenameUtils.getName(filePathAndName);

        //切换工作目录到根目录
        ftpClient.changeWorkingDirectory("/");
        ftpClient.changeWorkingDirectory(dirPath);
        FTPFile[] fs = ftpClient.listFiles();
        for (FTPFile ff : fs) {
            if (ff.getName().equals(fileName)) {
                //返回一个输入流，从该流可以读取来自服务器的命名文件
                inputStream = ftpClient.retrieveFileStream(fileName);
                if (inputStream == null) {
                    logger.error("下载附件{}失败！", fileName);
                }
                break;
            }
        }
        return inputStream;
    }

    /**
     * 下载文件,返回流，用户浏览器
     * @param filePathAndName  文件存储地址+文件名字
     * @param outFilePathAndName 输出文件的路径+文件名
     * @param ftpClient ftp客户端
     * @return  文件流
     * @throws Exception 异常
     */
    @Override
    public File downloadFile(String filePathAndName, String outFilePathAndName,
            FTPClient ftpClient) throws Exception {
        File file = null;
        FileOutputStream outputStream = null;
        try {
            String dirPath = FilenameUtils
                    .getFullPathNoEndSeparator(filePathAndName);
            String fileName = FilenameUtils.getName(filePathAndName);

            //切换工作目录到根目录
            ftpClient.changeWorkingDirectory("/");
            ftpClient.changeWorkingDirectory(dirPath);

            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    file = new File(outFilePathAndName);
                    outputStream = new FileOutputStream(file);
                    //从服务器检索命名文件并将其写入给定的outputStream流
                    ftpClient.retrieveFile(fileName,outputStream);
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("下载附件失败", e);
        }finally {
            IOUtils.closeQuietly(outputStream);
        }

        return file;
    }

    /**
     * 删除文件
     * @param filePathAndName  文件存储地址+文件名字
     * @param ftpClient ftp客户端
     * @return  是否删除成功
     */
    @Override
    public boolean deleteFile(String filePathAndName, FTPClient ftpClient) {
        String dirPath = FilenameUtils
                .getFullPathNoEndSeparator(filePathAndName);
        String fileName = FilenameUtils.getName(filePathAndName);

        return deleteFile(fileName, dirPath, ftpClient);
    }

    /**
     * 删除附件
     * @param fileName 文件名
     * @param dirPath 工作空间下的路径
     * @param ftpClient ftp客户端
     * @return 是否删除成功
     */
    @Override
    public boolean deleteFile(String fileName, String dirPath,
            FTPClient ftpClient) {
        boolean result = false;
        //切换工作目录到根目录
        try {
            ftpClient.changeWorkingDirectory("/");
            ftpClient.changeWorkingDirectory(dirPath);
            result = ftpClient.deleteFile(fileName);
        } catch (IOException e) {
            logger.error("删除附件失败", e);
        }
        return result;
    }

}
