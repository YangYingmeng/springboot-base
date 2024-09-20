package com.zhudao.springboot.rabbitmq._01base.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._01base.message.Message02Topic;

/**
 * TopicProducer
 *
 * @Description: TopicProducer
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:23
 */
public class TopicProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id, String routingKey) {

        Message02Topic msg = new Message02Topic().setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Message02Topic.EXCHANGE, routingKey, msg);
    }
}
