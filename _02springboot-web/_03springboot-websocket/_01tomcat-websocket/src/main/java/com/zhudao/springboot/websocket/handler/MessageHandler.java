package com.zhudao.springboot.websocket.handler;

import javax.websocket.Session;

import com.zhudao.springboot.websocket.message.Message;

/**
 * @Description: 消息处理器接口
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 16:01
 */
public interface MessageHandler<T extends Message> {

    /**
     * 执行处理消息
     *
     * @param session 会话
     * @param message 消息
     */
    void execute(Session session, T message);

    /**
     * @return 消息类型，即每个 Message 实现类上的 TYPE 静态字段
     */
    String getType();
}
