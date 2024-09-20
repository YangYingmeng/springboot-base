package com.zhudao.springboot.rabbitmq._06transaction.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._06transaction.message.TransactionMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 事务消息-消费者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/24 14:20
 */
@Slf4j
@RabbitListener(queues = TransactionMessage.QUEUE)
public class TransactionConsumer {

    @RabbitHandler
    public void onMessage(TransactionMessage message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
