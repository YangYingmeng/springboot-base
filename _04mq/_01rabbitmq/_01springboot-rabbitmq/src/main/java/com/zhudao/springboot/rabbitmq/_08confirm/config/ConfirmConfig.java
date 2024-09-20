package com.zhudao.springboot.rabbitmq._08confirm.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._08confirm.consumer.ConfirmConsumer;
import com.zhudao.springboot.rabbitmq._08confirm.message.ConfirmMessage;
import com.zhudao.springboot.rabbitmq._08confirm.producer.ConfirmProducer;

/**
 * 生产者发送消息确认配置
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 10:04
 */
@Configuration
@ConditionalOnProperty(name = "yml.prefix", havingValue = "confirm")
public class ConfirmConfig {

    public static class ConfirmDirectExchangeConfiguration {

        @Bean
        public Queue confirmQueue() {
            return QueueBuilder.durable(ConfirmMessage.QUEUE)
                    .build();
        }

        @Bean
        public DirectExchange confirmExchange() {
            return ExchangeBuilder.directExchange(ConfirmMessage.EXCHANGE)
                    .durable(true)
                    .build();
        }

        @Bean
        public Binding confirmBinding() {
            return BindingBuilder.bind(confirmQueue())
                    .to(confirmExchange())
                    .with(ConfirmMessage.ROUTING_KEY);
        }
    }


    @Bean
    public ConfirmConsumer confirmConsumer() {
        return new ConfirmConsumer();
    }

    @Bean
    public ConfirmProducer confirmProducer() {
        return new ConfirmProducer();
    }
}
