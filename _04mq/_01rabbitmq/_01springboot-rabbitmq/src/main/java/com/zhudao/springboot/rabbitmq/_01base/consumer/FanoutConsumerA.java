package com.zhudao.springboot.rabbitmq._01base.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._01base.message.Message03Fanout;

import lombok.extern.slf4j.Slf4j;

/**
 * FanoutConsumerA
 *
 * @Description: FanoutConsumerA
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:22
 */
@Slf4j
@RabbitListener(queues = Message03Fanout.QUEUE_A)
public class FanoutConsumerA {

    @RabbitHandler
    public void onMessage(Message03Fanout msg) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), msg);
    }

}
