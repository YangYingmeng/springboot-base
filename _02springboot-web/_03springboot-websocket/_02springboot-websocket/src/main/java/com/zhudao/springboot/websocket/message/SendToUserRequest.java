package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 发送消息给一个用户的 Message
 *
 * @Description: SendToUserRequest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 10:57
 */
@Data
@Accessors(chain = true)
public class SendToUserRequest implements Message {

    public static final String TYPE = "SEND_TO_USER_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;
}
