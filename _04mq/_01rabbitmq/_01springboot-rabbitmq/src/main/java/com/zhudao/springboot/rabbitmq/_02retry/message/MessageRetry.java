package com.zhudao.springboot.rabbitmq._02retry.message;

import lombok.Data;

import java.io.Serializable;

/**
 * 重试 消息实体
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 17:11
 */
@Data
public class MessageRetry implements Serializable {

    public static final String QUEUE = "QUEUE_RETRY";
    // 死信队列
    public static final String DEAD_QUEUE = "QUEUE_DEAD";

    public static final String EXCHANGE = "EXCHANGE_RETRY";

    public static final String RETRY_ROUTING_KEY = "ROUTING_RETRY";
    // 死信路由键
    public static final String DEAD_ROUTING_KEY = "ROUTING_DEAD";

    /**
     * 编号
     */
    private Integer id;


    @Override
    public String toString() {
        return "MessageRetry{" +
                "id=" + id +
                '}';
    }
}
