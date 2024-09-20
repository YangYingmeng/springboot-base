package com.zhudao.springboot.rabbitmq._04model.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.zhudao.springboot.rabbitmq._04model.message.BroadcastMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * 广播消费者
 * 将交换机和随机的UUID队列进行绑定, 每个消费者都有自己的队列
 * 交换机会将消息路由到每个队列中
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 10:05
 */
@Slf4j
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        name = BroadcastMessage.QUEUE + "-" + "#{T(java.util.UUID).randomUUID()}",
                        autoDelete = "true"
                ),
                exchange = @Exchange(
                        name = BroadcastMessage.EXCHANGE,
                        type = ExchangeTypes.TOPIC,
                        declare = "false"
                )
        )
)
public class BroadcastConsumer {

    @RabbitHandler
    public void onMessage(BroadcastMessage message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
