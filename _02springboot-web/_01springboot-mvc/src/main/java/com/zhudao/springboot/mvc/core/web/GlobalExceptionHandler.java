package com.zhudao.springboot.mvc.core.web;

import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhudao.springboot.mvc.constant.ServiceExceptionEnum;
import com.zhudao.springboot.mvc.core.exception.ServiceException;
import com.zhudao.springboot.mvc.core.vo.CommonResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: GlobalExceptionHandler
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 10:23
 */
@Slf4j
@ControllerAdvice(basePackages = "com.zhudao.springboot.mvc.controller")
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ServerException.class)
    public CommonResult serviceExceptionHandler(HttpServletRequest req, ServiceException ex) {

        log.debug("[serviceExceptionHandler]", ex);
        return CommonResult.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理 MissingServletRequestParameterException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingServletRequestParameterExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException ex) {

        log.debug("[missingServletRequestParameterExceptionHandler]", ex);
        return CommonResult.error(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(),
                ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    /**
     * 处理其它 Exception 异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest req, Exception e) {

        log.error("[exceptionHandler]", e);
        return CommonResult.error(ServiceExceptionEnum.SYS_ERROR.getCode(),
                ServiceExceptionEnum.SYS_ERROR.getMessage());
    }
}
