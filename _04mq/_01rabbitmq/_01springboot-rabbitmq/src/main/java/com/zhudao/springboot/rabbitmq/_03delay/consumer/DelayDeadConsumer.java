package com.zhudao.springboot.rabbitmq._03delay.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._03delay.message.MessageDelay;

import lombok.extern.slf4j.Slf4j;

/**
 * 延迟死信队列, 不用设置普通的消费队列, 模拟消费延迟
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 18:20
 */
@Slf4j
@RabbitListener(queues = MessageDelay.DELAY_DEAD_QUEUE)
public class DelayDeadConsumer {

    @RabbitHandler
    public void onMessage(MessageDelay message) {

        log.info("[onMessage][【死信队列】线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
