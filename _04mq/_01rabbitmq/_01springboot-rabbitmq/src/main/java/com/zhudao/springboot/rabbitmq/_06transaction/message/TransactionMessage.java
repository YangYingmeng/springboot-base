package com.zhudao.springboot.rabbitmq._06transaction.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 事务消费-消息
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 10:55
 */
@Data
@Accessors(chain = true)
public class TransactionMessage implements Serializable {


    public static final String EXCHANGE = "EXCHANGE_TRANSACTION";

    public static final String ROUTING_KEY = "ROUTING_KEY_TRANSACTION";

    public static final String QUEUE = "QUEUE_TRANSACTION";


    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "TransactionMessage{" +
                "id=" + id +
                '}';
    }
}
