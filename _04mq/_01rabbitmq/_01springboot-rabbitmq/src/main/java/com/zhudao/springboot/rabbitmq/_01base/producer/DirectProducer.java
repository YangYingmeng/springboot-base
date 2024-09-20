package com.zhudao.springboot.rabbitmq._01base.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.zhudao.springboot.rabbitmq._01base.message.Message01Direct;

/**
 * DirectProducer
 *
 * @Description: DirectProducer
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:23
 */
public class DirectProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 同步消息推送
     */
    public void syncSend(Integer id) {

        Message01Direct message = new Message01Direct().setId(id);
        rabbitTemplate.convertAndSend(Message01Direct.EXCHANGE, Message01Direct.ROUTING_KEY, message);
    }

    public void syncSendDefault(Integer id) {

        Message01Direct message = new Message01Direct().setId(id);
        rabbitTemplate.convertAndSend(Message01Direct.QUEUE, message);
    }

    /**
     * 异步消息推送
     */
    @Async
    public ListenableFuture<Void> asyncSend(Integer id) {
        try {

            this.syncSend(id);
            return AsyncResult.forValue(null);
        } catch (Throwable ex) {
            return AsyncResult.forExecutionException(ex);
        }
    }
}
