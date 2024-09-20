package com.zhudao.springboot.rabbitmq._10messageconverter.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._10messageconverter.message.ConverterMessage;

/**
 * 生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 14:58
 */
public class ConverterProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        ConverterMessage message = new ConverterMessage().setId(id);
        rabbitTemplate.convertAndSend(ConverterMessage.EXCHANGE, ConverterMessage.ROUTING_KEY, message);
    }
}
