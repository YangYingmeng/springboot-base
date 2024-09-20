package com.zhudao.springboot.validation.core.exception;

import com.zhudao.springboot.validation.constants.ServiceExceptionEnum;

/**
 * ServiceException
 *
 * @Description: ServiceException
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/13 14:27
 */
public class ServiceException extends RuntimeException{

    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        // 使用父类的 message 字段
        super(serviceExceptionEnum.getMessage());
        // 设置错误码
        this.code = serviceExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
