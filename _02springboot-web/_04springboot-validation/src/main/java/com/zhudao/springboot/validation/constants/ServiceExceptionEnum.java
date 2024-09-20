package com.zhudao.springboot.validation.constants;

/**
 * ServiceExceptionEnum
 *
 * @Description: ServiceExceptionEnum
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/13 14:28
 */
public enum ServiceExceptionEnum {

    // ========== 系统级别 ==========
    SUCCESS(0, "成功"),
    SYS_ERROR(2001001000, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(2001001001, "参数缺失"),
    INVALID_REQUEST_PARAM_ERROR(2001001002, "请求参数不合法"),
    USER_NOT_FOUND(1001002000, "用户不存在"),
    ;

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误提示
     */
    private final String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
