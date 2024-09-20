package com.zhudao.springboot.rabbitmq._02retry.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._02retry.message.MessageRetry;

import lombok.extern.slf4j.Slf4j;

/**
 * 死信队列
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 18:20
 */
@Slf4j
@RabbitListener(queues = MessageRetry.DEAD_QUEUE)
public class DeadConsumer {

    @RabbitHandler
    public void onMessage(MessageRetry message) {

        log.info("[onMessage][【死信队列】线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
