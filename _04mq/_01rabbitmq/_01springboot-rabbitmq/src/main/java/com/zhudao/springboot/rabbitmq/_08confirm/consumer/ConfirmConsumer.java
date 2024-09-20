package com.zhudao.springboot.rabbitmq._08confirm.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._08confirm.message.ConfirmMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 11:06
 */
@Slf4j
@RabbitListener(queues = ConfirmMessage.QUEUE)
public class ConfirmConsumer {

    @RabbitHandler
    public void onMessage(ConfirmMessage message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
