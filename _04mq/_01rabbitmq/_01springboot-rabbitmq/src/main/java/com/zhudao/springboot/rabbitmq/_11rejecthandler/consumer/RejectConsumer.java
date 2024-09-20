package com.zhudao.springboot.rabbitmq._11rejecthandler.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._11rejecthandler.message.RejectMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/30 11:31
 */
@Slf4j
@RabbitListener(queues = RejectMessage.QUEUE,
    errorHandler = "rabbitListenerErrorHandler")
public class RejectConsumer {

    @RabbitHandler
    public void onMessage(RejectMessage message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // 模拟消费异常
        throw new RuntimeException("你猜");
    }
}
