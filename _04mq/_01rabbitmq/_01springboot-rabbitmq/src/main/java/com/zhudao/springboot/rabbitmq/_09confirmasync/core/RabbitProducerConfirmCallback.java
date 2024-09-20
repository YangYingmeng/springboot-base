package com.zhudao.springboot.rabbitmq._09confirmasync.core;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import lombok.extern.slf4j.Slf4j;


/**
 * 处理生产者发布确认机制(消息已经发送到rabbitMQ, rabbitMQ回调确认方法)
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 14:14
 */
@Slf4j
public class RabbitProducerConfirmCallback implements RabbitTemplate.ConfirmCallback {

    /**
     * 注册当前回调方法
     */
    public RabbitProducerConfirmCallback(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("[confirm][Confirm 成功 correlationData: {}]", correlationData);
        } else {
            log.error("[confirm][Confirm 失败 correlationData: {} cause: {}]", correlationData, cause);
        }
    }
}
