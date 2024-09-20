package com.zhudao.springboot.rabbitmq._10messageconverter.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 生产者-json消息
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 10:02
 */
@Data
@Accessors(chain = true)
public class ConverterMessage implements Serializable {

    public static final String QUEUE = "QUEUE_CONVERTER";

    public static final String EXCHANGE = "EXCHANGE_CONVERTER";

    public static final String ROUTING_KEY = "ROUTING_CONVERTER";

    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "ConverterMessage{" +
                "id=" + id +
                '}';
    }
}
