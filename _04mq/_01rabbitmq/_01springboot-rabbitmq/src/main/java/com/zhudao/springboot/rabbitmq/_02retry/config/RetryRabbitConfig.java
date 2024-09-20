package com.zhudao.springboot.rabbitmq._02retry.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._02retry.consumer.DeadConsumer;
import com.zhudao.springboot.rabbitmq._02retry.consumer.RetryConsumer;
import com.zhudao.springboot.rabbitmq._02retry.message.MessageRetry;
import com.zhudao.springboot.rabbitmq._02retry.producer.RetryProducer;

/**
 * RabbitConfig
 *
 * @Description: RabbitConfig
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:09
 */
@Configuration
@ConditionalOnProperty(name = "yml.prefix", havingValue = "retry")
public class RetryRabbitConfig {


    /**
     * 消费重试机制
     */
    public static class RetryExchangeConfiguration {

        /**
         * 创建Queue
         */
        @Bean
        public Queue retryQueue() {
            return QueueBuilder.durable(MessageRetry.QUEUE)
                    .exclusive()
                    .autoDelete()
                    .deadLetterExchange(MessageRetry.EXCHANGE)
                    .deadLetterRoutingKey(MessageRetry.DEAD_ROUTING_KEY)
                    .build();
        }

        /**
         * 创建死信队列
         */
        @Bean
        public Queue deadQueue() {
            return QueueBuilder.durable(MessageRetry.DEAD_QUEUE)
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public DirectExchange retryExchange() {
            return ExchangeBuilder.directExchange(MessageRetry.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding
         */
        @Bean
        public Binding retryBinding() {
            return BindingBuilder.bind(retryQueue())
                    .to(retryExchange())
                    .with(MessageRetry.RETRY_ROUTING_KEY);
        }

        /**
         * 创建DeadBinding
         */
        @Bean
        public Binding deadBinding() {
            return BindingBuilder.bind(deadQueue())
                    .to(retryExchange())
                    .with(MessageRetry.DEAD_ROUTING_KEY);
        }
    }


    @Bean
    public DeadConsumer deadConsumer() {
        return new DeadConsumer();
    }
    @Bean
    public RetryConsumer retryConsumer() {
        return new RetryConsumer();
    }


    @Bean
    public RetryProducer retryProducer() {
        return new RetryProducer();
    }
}
