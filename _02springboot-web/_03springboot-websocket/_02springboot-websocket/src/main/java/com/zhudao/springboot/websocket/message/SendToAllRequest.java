package com.zhudao.springboot.websocket.message;

import lombok.Data;

/**
 * 发送给所有人的群聊消息的 Message
 *
 * @Description: SendToAllRequest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 10:25
 */
@Data
public class SendToAllRequest implements Message{

    public static final String TYPE = "SEND_TO_ALL_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;
}
