package com.zhudao.springboot.rabbitmq._05orderly.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 顺序消费-消息
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 10:55
 */
@Data
@Accessors(chain = true)
public class OrderlyMessage implements Serializable {

    private static final String QUEUE_BASE = "QUEUE_ORDERLY_10-";
    public static final String QUEUE_0 = QUEUE_BASE + "0";
    public static final String QUEUE_1 = QUEUE_BASE + "1";
    public static final String QUEUE_2 = QUEUE_BASE + "2";
    public static final String QUEUE_3 = QUEUE_BASE + "3";

    public static final int QUEUE_COUNT = 4;

    public static final String EXCHANGE = "EXCHANGE_ORDERLY_10";

    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "OrderlyMessage{" +
                "id=" + id +
                '}';
    }
}
