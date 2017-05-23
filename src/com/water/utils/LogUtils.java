package com.water.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Water on 17/5/17.
 * Email:water471871679@gmail.com
 */
public class LogUtils {
//    private static Logger logger = LogManager.getLogger(LogUtils.class);
//    public static void info(String info) {
//        logger.info(info);
//    }


    private static Logger logger = null;

    static {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        String callerClassName = stackTraceElements[1].getClassName();
        logger = LogManager.getLogger(callerClassName);
    }

    private LogUtils() {
    }

    //---------------------error---------------------------------
    public static void error(String param, String msg, Throwable e) {
        StackTraceElement se = Thread.currentThread().getStackTrace()[2];
        String clazzMethod = " " + se.getClassName() + "." + se.getMethodName() + "(" + se.getFileName() + ":" + se.getLineNumber() + ") ";

        String log = clazzMethod + " PARAMS: " + param + "	" + " MSG: " + msg;
        logger.error(log, e);
    }

    //---------------------warn----------------------------------
    public static void warn(String param, String msg) {
        StackTraceElement se = Thread.currentThread().getStackTrace()[2];
        String clazzMethod = " " + se.getClassName() + "." + se.getMethodName() + "(" + se.getFileName() + ":" + se.getLineNumber() + ") ";

        String log = clazzMethod + " PARAMS: " + param + "	" + " MSG: " + msg;
        logger.warn(log);
    }

    //---------------------info----------------------------------
    public static void info(String msg) {//
        StackTraceElement se = Thread.currentThread().getStackTrace()[2];
        String clazzMethod = " " + se.getClassName() + "." + se.getMethodName() + "(" + se.getFileName() + ":" + se.getLineNumber() + ") ";

        String log = clazzMethod + " MSG: " + msg;
        logger.info(log);
    }

    public static void info(String param, String msg) {//
        StackTraceElement se = Thread.currentThread().getStackTrace()[2];
        String clazzMethod = " " + se.getClassName() + "." + se.getMethodName() + "(" + se.getFileName() + ":" + se.getLineNumber() + ") ";

        String log = clazzMethod + " PARAMS: " + param + "	" + " MSG: " + msg;
        logger.info(log);
    }

    public static void debug(String msg) {
        StackTraceElement se = Thread.currentThread().getStackTrace()[2];
        String clazzMethod = " " + se.getClassName() + "." + se.getMethodName() + "(" + se.getFileName() + ":" + se.getLineNumber() + ") ";

        String log = clazzMethod + " MSG: " + msg;
        logger.debug(log);
    }
}
