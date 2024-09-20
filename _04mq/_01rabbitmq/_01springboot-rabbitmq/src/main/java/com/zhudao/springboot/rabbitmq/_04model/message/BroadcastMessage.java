package com.zhudao.springboot.rabbitmq._04model.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 广播消费-消息
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 9:36
 */
@Data
@Accessors(chain = true)
public class BroadcastMessage implements Serializable {

    public static final String QUEUE = "QUEUE_BROADCASTING";

    public static final String EXCHANGE = "EXCHANGE_BROADCASTING";

    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "BroadcastMessage{" +
                "id=" + id +
                '}';
    }
}
