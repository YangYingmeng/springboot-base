package com.zhudao.springboot.rabbitmq._05orderly.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._05orderly.consumer.OrderlyConsumer;
import com.zhudao.springboot.rabbitmq._05orderly.message.OrderlyMessage;
import com.zhudao.springboot.rabbitmq._05orderly.producer.OrderlyProducer;

/**
 * RabbitConfig
 *
 * @Description: RabbitConfig
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:09
 */
@Configuration
@ConditionalOnProperty(name = "yml.prefix", havingValue = "default")
public class OrderlyRabbitConfig {

    /**
     * 顺序消费配置
     */
    public static class OrderlyConfiguration {

        // 队列
        @Bean
        public Queue orderlyQueue0() {
            return QueueBuilder.durable(OrderlyMessage.QUEUE_0).build();
        }

        @Bean
        public Queue orderlyQueue1() {
            return QueueBuilder.durable(OrderlyMessage.QUEUE_1).build();
        }

        @Bean
        public Queue orderlyQueue2() {
            return QueueBuilder.durable(OrderlyMessage.QUEUE_2).build();
        }

        @Bean
        public Queue orderlyQueue3() {
            return QueueBuilder.durable(OrderlyMessage.QUEUE_3).build();
        }

        // 交换机
        @Bean
        public DirectExchange orderlyExchange() {
            return ExchangeBuilder.directExchange(OrderlyMessage.EXCHANGE)
                    .durable(true)
                    .build();
        }

        // 绑定关系
        @Bean
        public Binding orderlyBinding0() {
            return BindingBuilder.bind(orderlyQueue0()).to(orderlyExchange()).with("0");
        }

        @Bean
        public Binding orderlyBinding1() {
            return BindingBuilder.bind(orderlyQueue1()).to(orderlyExchange()).with("1");
        }

        @Bean
        public Binding orderlyBinding2() {
            return BindingBuilder.bind(orderlyQueue2()).to(orderlyExchange()).with("2");
        }

        @Bean
        public Binding orderlyBinding3() {
            return BindingBuilder.bind(orderlyQueue3()).to(orderlyExchange()).with("3");
        }
    }


    @Bean
    public OrderlyConsumer orderlyConsumer() {
        return new OrderlyConsumer();
    }

    @Bean
    public OrderlyProducer orderlyProducer() {
        return new OrderlyProducer();
    }
}
