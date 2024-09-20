package com.zhudao.springboot.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 发送消息响应结果的 Message
 *
 * @Description: SendResponse
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/11 10:23
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
