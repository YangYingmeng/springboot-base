package com.zhudao.springboot.mvc.core.exception;

import com.zhudao.springboot.mvc.constant.ServiceExceptionEnum;

/**
 * @Description: ServiceException
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 10:22
 */
public class ServiceException extends RuntimeException {

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
