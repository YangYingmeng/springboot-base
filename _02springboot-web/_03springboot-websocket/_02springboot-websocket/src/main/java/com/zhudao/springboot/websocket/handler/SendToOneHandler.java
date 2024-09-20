package com.zhudao.springboot.websocket.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import com.zhudao.springboot.websocket.message.SendToOneRequest;

/**
 * SendToOneHandler
 *
 * @Description: SendToOneHandler
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 11:09
 */
@Component
public class SendToOneHandler implements MessageHandler<SendToOneRequest> {

    @Override
    public void execute(WebSocketSession session, SendToOneRequest message) {

    }

    @Override
    public String getType() {
        return null;
    }
}
