package com.zhudao.springboot.rabbitmq._01base.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._01base.message.Message02Topic;

import lombok.extern.slf4j.Slf4j;

/**
 * TopicConsumer
 *
 * @Description: TopicConsumer
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:22
 */
@Slf4j
@RabbitListener(queues = Message02Topic.QUEUE)
public class TopicConsumer {

    @RabbitHandler
    public void onMessage(Message02Topic msg) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), msg);
    }

}
