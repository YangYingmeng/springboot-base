package com.zhudao.springboot.websocket.handler;

import javax.websocket.Session;

import com.zhudao.springboot.websocket.message.SendResponse;
import com.zhudao.springboot.websocket.message.SendToAllRequest;
import com.zhudao.springboot.websocket.message.SendToUserRequest;
import com.zhudao.springboot.websocket.util.WebSocketUtil;

/**
 * @Description: SendToAllHandler
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 16:51
 */
public class SendToAllHandler implements MessageHandler<SendToAllRequest> {

    @Override
    public void execute(Session session, SendToAllRequest message) {

        // 这里，假装直接成功
        SendResponse sendResponse = new SendResponse().setMsgId(message.getMsgId()).setCode(0);
        WebSocketUtil.send(session, SendResponse.TYPE, sendResponse);

        // 创建转发的消息
        SendToUserRequest sendToUserRequest = new SendToUserRequest().setMsgId(message.getMsgId())
                .setContent(message.getContent());
        // 广播发送
        WebSocketUtil.broadcast(SendToUserRequest.TYPE, sendToUserRequest);
    }

    @Override
    public String getType() {
        return null;
    }
}
