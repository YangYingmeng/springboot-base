package com.zhudao.springboot.rabbitmq._11rejecthandler.message;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/30 11:24
 */
@Data
@Accessors(chain = true)
public class RejectMessage implements Serializable {

    public static final String QUEUE = "QUEUE_REJECT";

    public static final String EXCHANGE = "EXCHANGE_REJECT";

    public static final String ROUTING_KEY = "ROUTING_REJECT";

    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "RejectMessage{" +
                "id=" + id +
                '}';
    }
}
