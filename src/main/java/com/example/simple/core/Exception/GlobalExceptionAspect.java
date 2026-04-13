package com.example.simple.core.Exception;

import com.example.simple.core.response.Response;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理类
 * 利用 @ControllerAdvice + @ExceptionHandler 组合处理Controller层RuntimeException异常
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionAspect {

    private static final Logger log = Logger.getLogger(GlobalExceptionAspect.class);

    /**
     * 处理自定义异常
     *
     * @param ex 自定义异常对象
     * @return 响应结果
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomException.class)
    public Response runtimeCustomExceptionHandler(CustomException ex) {
        log.error("用户异常...", ex);
        return new Response().failure(ex.getMsg(), ex.getCode());
    }

    /**
     * 处理业务异常
     *
     * @param ex 业务异常对象
     * @return 响应结果
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public Response runtimeBusinessExceptionHandler(BusinessException ex) {
        log.error("商业异常...", ex);
        return new Response().failure(ex.getResultCode().toString());
    }

    /**
     * 处理400错误 - 无法读取JSON
     *
     * @param e 异常对象
     * @return 响应结果
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("无法读取JSON...", e);
        return new Response().failure("无法读取JSON", 400);
    }

    /**
     * 处理400错误 - 参数验证异常
     *
     * @param e 异常对象
     * @return 响应结果
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleValidationException(MethodArgumentNotValidException e) {
        log.error("参数验证异常...", e);
        return new Response().failure("参数验证异常", 400);
    }

    /**
     * 处理404错误 - 资源未找到
     *
     * @param e 异常对象
     * @return 响应结果
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Response handlerNotFoundException(NoHandlerFoundException e) {
        log.error("请求的资源不可用", e);
        return new Response().failure("请求的资源不可用", 404);
    }

    /**
     * 处理405错误 - 请求方法不支持
     *
     * @param e 异常对象
     * @return 响应结果
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不合法的请求方法...", e);
        return new Response().failure("不合法的请求方法", 405);
    }

    /**
     * 处理415错误 - 不支持的媒体类型
     *
     * @param e 异常对象
     * @return 响应结果
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Response handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("内容类型不支持...", e);
        return new Response().failure("内容类型不支持", 415);
    }

    /**
     * 处理500错误 - 内部服务器错误
     *
     * @param e 异常对象
     * @return 响应结果
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.error("内部服务错误...", e);
        return new Response().failure("内部服务错误", 500);
    }
}
