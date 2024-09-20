package com.zhudao.springboot.rabbitmq._09confirmasync.core;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * 处理消息未能分配到消息队列中的情况(路由不匹配)
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 14:28
 */
@Slf4j
public class RabbitProducerReturnCallback implements RabbitTemplate.ReturnCallback {

    public RabbitProducerReturnCallback(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.error("[returnedMessage][message: [{}] replyCode: [{}] replyText: [{}] exchange: [{}] routingKey: [{}]]",
                message, replyCode, replyText, exchange, routingKey);
    }
}
