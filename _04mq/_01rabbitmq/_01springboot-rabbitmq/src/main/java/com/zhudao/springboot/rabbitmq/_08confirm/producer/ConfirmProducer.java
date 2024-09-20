package com.zhudao.springboot.rabbitmq._08confirm.producer;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.rabbitmq.client.ConfirmCallback;
import com.zhudao.springboot.rabbitmq._08confirm.message.ConfirmMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 生产者-发布确认
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 10:54
 */
@Slf4j
public class ConfirmProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        ConfirmMessage message = new ConfirmMessage().setId(id);
        // 同步发送消息, 生产者发送确认
        rabbitTemplate.invoke(new RabbitOperations.OperationsCallback<Object>() {

            @Override
            public Object doInRabbit(RabbitOperations operations) {
                operations.convertAndSend(ConfirmMessage.EXCHANGE, ConfirmMessage.ROUTING_KEY, message);
                log.info("[doInRabbit][发送消息完成]");
                // 等待确认(同步)
                operations.waitForConfirms(0);
                log.info("[doInRabbit][等待 Confirm 完成]");
                return null;
            }
        }, new ConfirmCallback() {
            @Override
            public void handle(long l, boolean b) throws IOException {
                log.info("[handle][Confirm 成功]");
            }
        }, new ConfirmCallback() {
            @Override
            public void handle(long l, boolean b) throws IOException {
                log.info("[handle][Confirm 失败]");
            }
        });
    }
}
