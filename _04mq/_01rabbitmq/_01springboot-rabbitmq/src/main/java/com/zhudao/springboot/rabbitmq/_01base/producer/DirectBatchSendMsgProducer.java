package com.zhudao.springboot.rabbitmq._01base.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;

import com.zhudao.springboot.rabbitmq._01base.message.Message04Batch;

/**
 * 批量发送生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/9 17:37
 */
public class DirectBatchSendMsgProducer {

    @Resource
    private BatchingRabbitTemplate rabbitTemplate;

    /**
     * 同步消息推送
     */
    public void syncSend(Integer id) {

        Message04Batch message = new Message04Batch().setId(id);
        rabbitTemplate.convertAndSend(Message04Batch.EXCHANGE, Message04Batch.ROUTING_KEY, message);
    }

}
