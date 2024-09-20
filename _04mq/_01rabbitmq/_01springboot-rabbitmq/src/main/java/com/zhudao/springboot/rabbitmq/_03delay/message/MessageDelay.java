package com.zhudao.springboot.rabbitmq._03delay.message;

import java.io.Serializable;

import lombok.Data;

/**
 * 延迟 消息实体
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 17:11
 */
@Data
public class MessageDelay implements Serializable {

    public static final String QUEUE = "QUEUE_DELAY";
    // 死信队列
    public static final String DELAY_DEAD_QUEUE = "QUEUE_DELAY_DEAD";

    public static final String EXCHANGE = "EXCHANGE_DELAY";

    public static final String ROUTING_KEY = "ROUTING_DELAY";
    // 死信路由键
    public static final String DELAY_DEAD_ROUTING_KEY = "ROUTING_DELAY_DEAD";

    /**
     * 编号
     */
    private Integer id;


    @Override
    public String toString() {
        return "MessageDelay{" +
                "id=" + id +
                '}';
    }
}
