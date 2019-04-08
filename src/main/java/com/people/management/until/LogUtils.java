package com.people.management.until;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class LogUtils {

    /**
     * 获取业务日志logger
     *
     * @return
     */
    public static Logger getBussinessLogger(){
        return (Logger) LoggerFactory.getLogger(LogEnum.BUSSINESS.getCategory());
    }

    /**
     * 获取平台日志 logger
     */
    public static Logger getPlatformLogger(){
        return (Logger) LoggerFactory.getLogger(LogEnum.PLATFORM.getCategory());
    }

    /**
     * 获取数据库日志logger
     *
     * @return
     */
    public static Logger getDBLogger() {
        return (Logger) LoggerFactory.getLogger(LogEnum.DB.getCategory());
    }


    /**
     * 获取异常日志logger
     *
     * @return
     */
    public static Logger getExceptionLogger() {
        return (Logger) LoggerFactory.getLogger(LogEnum.EXCEPTION.getCategory());
    }
}
