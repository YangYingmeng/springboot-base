package com.zhudao.springboot.rabbitmq._07ack.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._07ack.message.AckMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/24 15:41
 */
@Slf4j
public class AckProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {

        AckMessage message = new AckMessage().setId(id);
        rabbitTemplate.convertAndSend(AckMessage.EXCHANGE, AckMessage.ROUTING_KEY, message);
    }
}
