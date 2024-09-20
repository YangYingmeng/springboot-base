package com.zhudao.springboot.rabbitmq._06transaction.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.zhudao.springboot.rabbitmq._06transaction.message.TransactionMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 事务消息-生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/24 14:15
 */
@Slf4j
public class TransactionProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;


    @Transactional
    public void syncSend(Integer id) throws InterruptedException {

        TransactionMessage message = new TransactionMessage().setId(id);
        rabbitTemplate.convertAndSend(TransactionMessage.EXCHANGE, TransactionMessage.ROUTING_KEY, message);
        log.info("[syncSend][发送编号：[{}] 发送成功]", id);

        // 等待, 如果消息立马被消费没有等待说明事务未生效;
        Thread.sleep(10 * 1000L);
    }
}
