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
public class Message01Direct implements Serializable {

    public static final String QUEUE = "QUEUE_01_direct";

    public static final String EXCHANGE = "EXCHANGE_01_direct";

    public static final String ROUTING_KEY = "ROUTING_01_direct";

    /**
     * 编号
     */
    private Integer id;
}
