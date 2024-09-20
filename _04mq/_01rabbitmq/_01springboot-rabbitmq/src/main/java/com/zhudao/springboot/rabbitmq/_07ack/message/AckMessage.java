package com.zhudao.springboot.rabbitmq._07ack.message;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/24 15:38
 */
@Data
@Accessors(chain = true)
public class AckMessage implements Serializable {

    public static final String EXCHANGE = "EXCHANGE_ACK";

    public static final String ROUTING_KEY = "ROUTING_KEY_ACK";

    public static final String QUEUE = "QUEUE_ACK";

    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "AckMessage{" +
                "id=" + id +
                '}';
    }
}
