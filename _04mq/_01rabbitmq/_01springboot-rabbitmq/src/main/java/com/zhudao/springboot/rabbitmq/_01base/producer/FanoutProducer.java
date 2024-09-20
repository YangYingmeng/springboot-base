package com.zhudao.springboot.rabbitmq._01base.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._01base.message.Message03Fanout;

/**
 * FanoutProducer
 *
 * @Description: FanoutProducer
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:23
 */
public class FanoutProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {

        Message03Fanout msg = new Message03Fanout().setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(Message03Fanout.EXCHANGE, null, msg);
    }
}
