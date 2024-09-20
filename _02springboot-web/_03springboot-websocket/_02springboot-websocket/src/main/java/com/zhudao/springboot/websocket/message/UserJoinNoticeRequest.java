package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户加入群聊的通知 Message
 *
 * @Description: UserJoinNoticeRequest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 10:58
 */
@Data
@Accessors(chain = true)
public class UserJoinNoticeRequest implements Message {

    public static final String TYPE = "USER_JOIN_NOTICE_REQUEST";

    /**
     * 昵称
     */
    private String nickname;
}
