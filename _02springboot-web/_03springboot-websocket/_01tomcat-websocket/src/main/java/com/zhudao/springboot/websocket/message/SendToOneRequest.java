package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 发送给指定人的私聊消息的 Message
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 15:40
 */
@Data
@Accessors(chain = true)
public class SendToOneRequest implements Message {

    public static final String TYPE = "SEND_TO_ONE_REQUEST";

    /**
     * 发送给的用户
     */
    private String toUser;
    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;
}
