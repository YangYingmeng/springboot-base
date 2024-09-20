package com.zhudao.springboot.rabbitmq._09confirmasync.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._09confirmasync.message.ConfirmAsyncMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 14:07
 */
@Slf4j
@RabbitListener(queues = ConfirmAsyncMessage.QUEUE)
public class ConfirmAsyncConsumer {

    @RabbitHandler
    public void onMessage(ConfirmAsyncMessage message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
