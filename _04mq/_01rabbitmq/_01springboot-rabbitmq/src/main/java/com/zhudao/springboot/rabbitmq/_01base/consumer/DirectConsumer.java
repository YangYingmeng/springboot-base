package com.zhudao.springboot.rabbitmq._01base.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._01base.message.Message01Direct;

import lombok.extern.slf4j.Slf4j;

/**
 * DirectConsumer
 *
 * @Description: DirectConsumer
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:22
 */
@Slf4j
@RabbitListener(queues = Message01Direct.QUEUE)
public class DirectConsumer {

    @RabbitHandler
    public void onMessage(Message01Direct msg) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), msg);
    }

    /**
     * 该方法可以获取创建时间 key等信息
     */
//    @RabbitHandler(isDefault = true)
//    public void onMessage(org.springframework.amqp.core.Message msg) {
//        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), msg);
//    }
}
