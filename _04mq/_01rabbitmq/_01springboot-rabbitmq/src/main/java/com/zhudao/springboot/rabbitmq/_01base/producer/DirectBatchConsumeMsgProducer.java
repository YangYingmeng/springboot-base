package com.zhudao.springboot.rabbitmq._01base.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;

import com.zhudao.springboot.rabbitmq._01base.message.Message05Batch;

/**
 * 批量发送生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/9 17:37
 */
public class DirectBatchConsumeMsgProducer {

    @Resource
    private BatchingRabbitTemplate batchingRabbitTemplate;

    /**
     * 同步消息推送
     */
    public void syncSend(Integer id) {

        Message05Batch message = new Message05Batch().setId(id);
        batchingRabbitTemplate.convertAndSend(Message05Batch.EXCHANGE, Message05Batch.ROUTING_KEY, message);
    }

}
