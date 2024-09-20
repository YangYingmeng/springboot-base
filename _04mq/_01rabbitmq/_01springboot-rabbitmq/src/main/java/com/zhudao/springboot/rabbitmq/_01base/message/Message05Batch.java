package com.zhudao.springboot.rabbitmq._01base.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 批量消费消息实体
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/9 16:17
 */
@Data
@Accessors(chain = true)
public class Message05Batch implements Serializable {

    public static final String QUEUE = "QUEUE_05_direct_batch_consume";
    public static final String EXCHANGE = "EXCHANGE_05_direct_batch_consume";
    public static final String ROUTING_KEY = "ROUTING_05_direct_batch_consume";


    /**
     * 编号
     */
    private Integer id;
}
