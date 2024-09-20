package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 用户认证响应
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 15:38
 */
@Data
@Accessors(chain = true)
public class AuthResponse implements Message{

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
