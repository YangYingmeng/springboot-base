package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户认证响应
 *
 * @Description: AuthResponse
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 10:22
 */
@Data
@Accessors(chain = true)
public class AuthResponse implements Message {

    public static final String TYPE = "AUTH_RESPONSE";

    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应提示
     */
    private String message;
}
