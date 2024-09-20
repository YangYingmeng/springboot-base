package com.zhudao.springboot.websocket.handler;

import javax.websocket.Session;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.zhudao.springboot.websocket.message.AuthRequest;
import com.zhudao.springboot.websocket.message.AuthResponse;
import com.zhudao.springboot.websocket.message.UserJoinNoticeRequest;
import com.zhudao.springboot.websocket.util.WebSocketUtil;

/**
 * @Description: AuthMessageHandler
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 16:02
 */
@Component
public class AuthMessageHandler implements MessageHandler<AuthRequest> {

    @Override
    public void execute(Session session, AuthRequest message) {

        if (StringUtils.isEmpty(message.getAccessToken())) {
            WebSocketUtil.send(session, AuthResponse.TYPE,
                    new AuthResponse().setCode(1).setMessage("认证 accessToken 未传入"));
        }
        // 记录认证信息
        WebSocketUtil.addSession(session, message.getAccessToken());
        // 假装直接成功
        WebSocketUtil.send(session, AuthResponse.TYPE, new AuthResponse().setCode(0));
        // 通知所有人, 某个人加入了
        WebSocketUtil.broadcast(UserJoinNoticeRequest.TYPE,
                new UserJoinNoticeRequest().setNickname(message.getAccessToken()));
    }

    @Override
    public String getType() {
        return AuthRequest.TYPE;
    }
}
