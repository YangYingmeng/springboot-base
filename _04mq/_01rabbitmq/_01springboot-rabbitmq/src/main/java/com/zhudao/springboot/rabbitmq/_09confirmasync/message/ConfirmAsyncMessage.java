package com.zhudao.springboot.rabbitmq._09confirmasync.message;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 生产者-发送消息确认
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 10:02
 */
@Data
@Accessors(chain = true)
public class ConfirmAsyncMessage implements Serializable {

    public static final String QUEUE = "QUEUE_CONFIRM_ASYNC";

    public static final String EXCHANGE = "EXCHANGE_CONFIRM_ASYNC";

    public static final String ROUTING_KEY = "ROUTING_CONFIRM_ASYNC";

    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "ConfirmAsyncMessage{" +
                "id=" + id +
                '}';
    }
}
