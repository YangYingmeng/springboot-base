package com.zhudao.springboot.websocket.handler;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketSession;

import com.zhudao.springboot.websocket.message.AuthRequest;
import com.zhudao.springboot.websocket.message.AuthResponse;
import com.zhudao.springboot.websocket.message.UserJoinNoticeRequest;
import com.zhudao.springboot.websocket.util.WebSocketUtil;

/**
 * @Description: AuthMessageHandler
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 11:03
 */
@Component
public class AuthMessageHandler implements MessageHandler<AuthRequest> {


    @Override
    public void execute(WebSocketSession session, AuthRequest message) {

        // 如果未传递 accessToken
        if (StringUtils.isEmpty(message.getAccessToken())) {
            WebSocketUtil.send(session, AuthResponse.TYPE,
                    new AuthResponse().setCode(1).setMessage("认证 accessToken 未传入"));
            return;
        }

        // 添加到 WebSocketUtil 中
        WebSocketUtil.addSession(session, message.getAccessToken()); // 考虑到代码简化，我们先直接使用 accessToken 作为 User

        // 判断是否认证成功。这里，假装直接成功
        WebSocketUtil.send(session, AuthResponse.TYPE, new AuthResponse().setCode(0));

        // 通知所有人，某个人加入了。这个是可选逻辑，仅仅是为了演示
        WebSocketUtil.broadcast(UserJoinNoticeRequest.TYPE,
                new UserJoinNoticeRequest().setNickname(message.getAccessToken()));
    }

    @Override
    public String getType() {
        return AuthRequest.TYPE;
    }
}
