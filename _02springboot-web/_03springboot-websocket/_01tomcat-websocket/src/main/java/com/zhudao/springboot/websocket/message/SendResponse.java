package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 发送消息响应结果的 Message
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 15:39
 */
@Data
@Accessors(chain = true)
public class SendResponse implements Message {

    public static final String TYPE = "SEND_RESPONSE";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应提示
     */
    private String message;
}
