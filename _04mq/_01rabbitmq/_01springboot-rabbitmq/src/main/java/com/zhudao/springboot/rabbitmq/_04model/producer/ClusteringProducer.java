package com.zhudao.springboot.rabbitmq._04model.producer;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._04model.message.ClusteringMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 集群消费-生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 10:10
 */
@Slf4j
public class ClusteringProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        ClusteringMessage message = new ClusteringMessage().setId(id);
        rabbitTemplate.convertAndSend(ClusteringMessage.EXCHANGE, null, message);
    }
}
