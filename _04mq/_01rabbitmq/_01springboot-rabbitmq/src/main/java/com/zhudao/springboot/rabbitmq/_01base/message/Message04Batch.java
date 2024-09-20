package com.zhudao.springboot.rabbitmq._01base.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 批量发送消息实体
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/9 16:17
 */
@Data
@Accessors(chain = true)
public class Message04Batch implements Serializable {

    public static final String QUEUE = "QUEUE_04_direct_batch";
    public static final String EXCHANGE = "EXCHANGE_04_direct_batch";
    public static final String ROUTING_KEY = "ROUTING_04_direct_batch";


    /**
     * 编号
     */
    private Integer id;
}
