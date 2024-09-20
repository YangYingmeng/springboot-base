package com.zhudao.springboot.rabbitmq._07ack.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._07ack.consumer.AckConsumer;
import com.zhudao.springboot.rabbitmq._07ack.message.AckMessage;
import com.zhudao.springboot.rabbitmq._07ack.producer.AckProducer;

/**
 * 消费者手动确认
 *
 * @Description: RabbitConfig
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:09
 */
@Configuration
@ConditionalOnProperty(name = "yml.prefix", havingValue = "ack")
public class AckRabbitConfig {

    /**
     * Direct Exchange 配置
     */
    public static class DirectExchangeConfiguration {

        /**
         * 创建Queue
         */
        @Bean
        public Queue ackQueue() {
            return QueueBuilder.durable(AckMessage.QUEUE)
                    //.autoDelete() // 队列在没有消费者时, 自动删除
                    //.exclusive() // 队列只能被 Message01Direct.QUEUE 连接使用
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public DirectExchange ackExchange() {
            return ExchangeBuilder.directExchange(AckMessage.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding
         */
        @Bean
        public Binding ackBinding() {
            return BindingBuilder.bind(ackQueue())
                    .to(ackExchange()).with(AckMessage.ROUTING_KEY);
        }
    }


    @Bean
    public AckConsumer ackConsumer() {
        return new AckConsumer();
    }

    @Bean
    public AckProducer ackProducer() {
        return new AckProducer();
    }
}
