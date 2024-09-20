package com.zhudao.springboot.rabbitmq._04model.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._04model.message.BroadcastMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 广播消费-生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 9:53
 */
@Slf4j
public class BroadcastProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        BroadcastMessage message = new BroadcastMessage().setId(id);
        rabbitTemplate.convertAndSend(BroadcastMessage.EXCHANGE, null, message);
    }
}
