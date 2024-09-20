package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 用户加入群聊的通知 Message
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 15:58
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
