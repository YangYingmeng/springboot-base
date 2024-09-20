package com.zhudao.springboot.rabbitmq._01base.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Message03Fanout
 *
 * @Description: Message03Fanout
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:09
 */
@Data
@Accessors(chain = true)
public class Message03Fanout implements Serializable {

    public static final String QUEUE_A = "QUEUE_03_fanout_A";
    public static final String QUEUE_B = "QUEUE_03_fanout_B";
    // 消息路由到绑定该交换机的所有路由上
    public static final String EXCHANGE = "EXCHANGE_03_fanout";

    /**
     * 编号
     */
    private Integer id;
}
