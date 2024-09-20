package com.zhudao.springboot.websocket.message;

/**
 * 发送给指定人的私聊消息的 Message
 *
 * @Description: SendToOneRequest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 10:48
 */
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
