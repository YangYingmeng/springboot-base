package com.zhudao.springboot.websocket.handler;

import org.springframework.web.socket.WebSocketSession;

import com.zhudao.springboot.websocket.message.Message;

/**
 * 消息处理器接口
 *
 * @Description: MessageHandler
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 11:02
 */
public interface MessageHandler<T extends Message> {

    /**
     * 执行处理消息
     *
     * @param session 会话
     * @param message 消息
     */
    void execute(WebSocketSession session, T message);

    /**
     * @return 消息类型，即每个 Message 实现类上的 TYPE 静态字段
     */
    String getType();
}
