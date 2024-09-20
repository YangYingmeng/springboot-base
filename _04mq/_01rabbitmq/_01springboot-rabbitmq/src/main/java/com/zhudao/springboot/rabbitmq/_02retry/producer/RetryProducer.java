package com.zhudao.springboot.rabbitmq._02retry.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._02retry.message.MessageRetry;

/**
 * 重试生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 18:23
 */
public class RetryProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo07Message 消息
        MessageRetry message = new MessageRetry();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(MessageRetry.EXCHANGE, MessageRetry.RETRY_ROUTING_KEY, message);
    }
}
