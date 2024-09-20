package com.zhudao.springboot.rabbitmq._08confirm.message;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 生产者-发送消息确认
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 10:02
 */
@Data
@Accessors(chain = true)
public class ConfirmMessage implements Serializable {

    public static final String QUEUE = "QUEUE_CONFIRM";

    public static final String EXCHANGE = "EXCHANGE_CONFIRM";

    public static final String ROUTING_KEY = "ROUTING_CONFIRM";

    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "ConfirmMessage{" +
                "id=" + id +
                '}';
    }
}
