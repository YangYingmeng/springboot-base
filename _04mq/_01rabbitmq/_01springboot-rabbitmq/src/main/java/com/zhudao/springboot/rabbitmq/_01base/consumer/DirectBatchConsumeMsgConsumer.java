package com.zhudao.springboot.rabbitmq._01base.consumer;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._01base.message.Message05Batch;

import lombok.extern.slf4j.Slf4j;

/**
 * 批量消费
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/11 15:03
 */
@Slf4j
@RabbitListener(queues = Message05Batch.QUEUE,
        containerFactory = "batchConsumeContainerFactory")
public class DirectBatchConsumeMsgConsumer {

    @RabbitHandler
    public void onMessage(List<Message05Batch> messages) {
        log.info("[onMessage][线程编号:{} 消息数量：{}]", Thread.currentThread().getId(), messages.size());
    }
}
