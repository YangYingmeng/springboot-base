package com.zhudao.springboot.rabbitmq._01base.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Message01Direct
 *
 * @Description: Message01Direct
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:09
 */
@Data
@Accessors(chain = true)
public class Message02Topic implements Serializable {

    public static final String QUEUE = "QUEUE_02_topic";

    public static final String EXCHANGE = "EXCHANGE_02_topic";
    // *可匹配多个单词, #只能匹配一个单词
    public static final String ROUTING_KEY = "#.zhu.dao";

    /**
     * 编号
     */
    private Integer id;
}
