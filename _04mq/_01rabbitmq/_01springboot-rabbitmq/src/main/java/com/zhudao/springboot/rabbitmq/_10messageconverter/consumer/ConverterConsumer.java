package com.zhudao.springboot.rabbitmq._10messageconverter.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._10messageconverter.message.ConverterMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 15:00
 */
@Slf4j
@RabbitListener(queues = ConverterMessage.QUEUE)
public class ConverterConsumer {

    @RabbitHandler
    public void onMessage(Message message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                new String(message.getBody()));
    }
}
