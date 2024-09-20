package com.zhudao.springboot.rabbitmq._02retry.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._02retry.message.MessageRetry;

import lombok.extern.slf4j.Slf4j;

/**
 * 普通队列
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 18:20
 */
@Slf4j
@RabbitListener(queues = MessageRetry.QUEUE)
public class RetryConsumer {

    @RabbitHandler
    public void onMessage(MessageRetry message) {

        // 接收到消息 但是异常导致消费失败
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // <X> 注意，此处抛出一个 RuntimeException 异常，模拟消费失败
        throw new RuntimeException("我就是故意抛出一个异常");
    }
}
