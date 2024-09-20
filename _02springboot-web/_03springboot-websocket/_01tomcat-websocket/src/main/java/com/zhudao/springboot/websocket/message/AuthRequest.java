package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 用户认证请求
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 15:36
 */
@Data
@Accessors(chain = true)
public class AuthRequest implements Message {

    public static final String TYPE = "AUTH_REQUEST";

    private String accessToken;
}
