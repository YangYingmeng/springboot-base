package com.zhudao.springboot.rabbitmq._05orderly.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;

import com.zhudao.springboot.rabbitmq._05orderly.message.OrderlyMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 顺序消费-消费者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 11:06
 */
@Slf4j
@RabbitListener(queues = OrderlyMessage.QUEUE_0)
@RabbitListener(queues = OrderlyMessage.QUEUE_1)
@RabbitListener(queues = OrderlyMessage.QUEUE_2)
@RabbitListener(queues = OrderlyMessage.QUEUE_3)
public class OrderlyConsumer {

    /**
     * getPayload() 访问Message的实际对象
     */
    @RabbitHandler(isDefault = true)
    public void onMessage(Message<OrderlyMessage> message) {
        log.info("[onMessage][线程编号:{} Queue:{} 消息编号：{}]", Thread.currentThread().getId(), getQueue(message),
                message.getPayload().getId());
    }

    private static String getQueue(Message<OrderlyMessage> message) {
        return message.getHeaders().get("amqp_consumerQueue", String.class);
    }
}
