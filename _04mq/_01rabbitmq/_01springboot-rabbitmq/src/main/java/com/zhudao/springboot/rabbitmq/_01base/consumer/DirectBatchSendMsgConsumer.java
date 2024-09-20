package com.zhudao.springboot.rabbitmq._01base.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._01base.message.Message04Batch;

import lombok.extern.slf4j.Slf4j;

/**
 * 批量发送消息
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/9 17:42
 */
@Slf4j
@RabbitListener(queues = Message04Batch.QUEUE)
public class DirectBatchSendMsgConsumer {

    @RabbitHandler
    public void onMessage(Message04Batch msg) {

        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), msg);
    }

}
