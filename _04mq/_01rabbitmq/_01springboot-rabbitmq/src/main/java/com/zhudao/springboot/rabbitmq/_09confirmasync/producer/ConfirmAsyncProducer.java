package com.zhudao.springboot.rabbitmq._09confirmasync.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._09confirmasync.message.ConfirmAsyncMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 异步生产者Confirm
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 14:04
 */
@Slf4j
public class ConfirmAsyncProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        ConfirmAsyncMessage message = new ConfirmAsyncMessage().setId(id);
        rabbitTemplate.convertAndSend(ConfirmAsyncMessage.EXCHANGE, ConfirmAsyncMessage.ROUTING_KEY, message);
    }


    public void syncSendReturn(Integer id) {
        ConfirmAsyncMessage message = new ConfirmAsyncMessage().setId(id);
        rabbitTemplate.convertAndSend(ConfirmAsyncMessage.EXCHANGE, "te", message);
    }
}
