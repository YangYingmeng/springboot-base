package com.zhudao.springboot.rabbitmq._11rejecthandler.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._11rejecthandler.message.RejectMessage;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/30 11:29
 */
public class RejectProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        RejectMessage message = new RejectMessage().setId(id);
        rabbitTemplate.convertAndSend(RejectMessage.EXCHANGE, RejectMessage.ROUTING_KEY, message);
    }
}
