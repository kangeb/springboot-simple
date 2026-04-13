package com.example.simple.core.Exception;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 * 提供异常相关的工具方法
 */
public class Exceptions {

    /**
     * 将CheckedException转换为UncheckedException
     *
     * @param e 异常对象
     * @return RuntimeException对象
     */
    public static RuntimeException unchecked(Exception e) {
        if ((e instanceof RuntimeException)) {
            return (RuntimeException) e;
        }
        return new RuntimeException(e);
    }

    /**
     * 获取异常的堆栈跟踪信息字符串
     *
     * @param e 异常对象
     * @return 堆栈跟踪信息字符串
     */
    public static String getStackTraceAsString(Throwable e) {
        if (e == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /**
     * 判断异常是否由某些异常引起
     *
     * @param ex                   异常对象
     * @param causeExceptionClasses 可能的异常类型数组
     * @return 是否由指定异常引起
     */
    public static boolean isCausedBy(Exception ex, Class<? extends Exception>[] causeExceptionClasses) {
        Throwable cause = ex.getCause();
        while (cause != null) {
            for (Class causeClass : causeExceptionClasses) {
                if (causeClass.isInstance(cause)) {
                    return true;
                }
            }
            cause = cause.getCause();
        }
        return false;
    }

    /**
     * 从请求中获取异常对象
     *
     * @param request HTTP请求对象
     * @return 异常对象
     */
    public static Throwable getThrowable(HttpServletRequest request) {
        Throwable ex = null;
        if (request.getAttribute("exception") != null)
            ex = (Throwable) request.getAttribute("exception");
        else if (request.getAttribute("javax.servlet.error.exception") != null) {
            ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
        }
        return ex;
    }
}
