package com.thunisoft.shop.service.impl;

import org.apache.commons.io.FileUtils;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 清除图片定时任务
 */
public class CleanImageTaskServiceImpl {

    /** 日志组件. */
    private static final Logger logger = LoggerFactory.getLogger(CleanImageTaskServiceImpl.class);

    /**
     * 定时任务入口方法
     * @throws SchedulerException 任务异常
     */
    public void doJob() throws SchedulerException {
        logger.info("每天清除图片定时任务开始");

        String download = "/resource/download";
        String resourcePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        int indexOf = resourcePath.lastIndexOf("/WEB-INF");
        String localFilePath = resourcePath.substring(1,indexOf);
        String downloadPath = localFilePath + download;

        //清空目录下的所有文件（包括下级目录）
        File file = new File(downloadPath);
        try {
            FileUtils.cleanDirectory(file);
        } catch (IOException e) {
            logger.error("清除{}下图片失败",downloadPath);
        }


    }
}
