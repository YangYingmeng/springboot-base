package com.zhudao.springboot.rabbitmq._04model.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._04model.message.ClusteringMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 集群消费者
 * 交换机将消息发给某一个队列
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 10:13
 */
@Slf4j
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        name = ClusteringMessage.QUEUE + "-" + "GROUP_01"
                ),
                exchange = @Exchange(
                        name = ClusteringMessage.EXCHANGE,
                        type = ExchangeTypes.TOPIC,
                        declare = "false"
                ),
                key = "#"
        )
)
public class ClusteringConsumer {

    @RabbitHandler
    public void onMessage(ClusteringMessage message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
