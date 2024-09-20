package com.zhudao.springboot.rabbitmq._05orderly.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._05orderly.message.OrderlyMessage;

/**
 * 顺序消息-生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 11:03
 */
public class OrderlyProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 消息按照队列名后缀求余, 按照顺序发送
     */
    public void syncSend(Integer id) {
        OrderlyMessage message = new OrderlyMessage().setId(id);
        rabbitTemplate.convertAndSend(OrderlyMessage.EXCHANGE, this.getRoutingKey(id), message);
    }

    private String getRoutingKey(Integer id) {
        return String.valueOf(id % OrderlyMessage.QUEUE_COUNT);
    }

}
