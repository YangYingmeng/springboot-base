package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户认证请求
 *
 * @Description: AuthRequest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 10:21
 */
@Data
@Accessors(chain = true)
public class AuthRequest implements Message {

    public static final String TYPE = "AUTH_REQUEST";

    /**
     * 认证 Token
     */
    private String accessToken;
}
