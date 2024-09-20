package com.zhudao.springboot.rabbitmq._06transaction.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._06transaction.consumer.TransactionConsumer;
import com.zhudao.springboot.rabbitmq._06transaction.message.TransactionMessage;
import com.zhudao.springboot.rabbitmq._06transaction.producer.TransactionProducer;

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
public class TransactionRabbitConfig {

    /**
     * Direct Exchange 配置
     */
    public static class DirectExchangeConfiguration {

        /**
         * 创建Queue
         */
        @Bean
        public Queue transactionQueue() {
            return QueueBuilder.durable(TransactionMessage.QUEUE)
                    //.autoDelete() // 队列在没有消费者时, 自动删除
                    //.exclusive() // 队列只能被 Message01Direct.QUEUE 连接使用
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public DirectExchange transactionExchange() {
            return ExchangeBuilder.directExchange(TransactionMessage.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding
         */
        @Bean
        public Binding transactionBinding() {
            return BindingBuilder.bind(transactionQueue())
                    .to(transactionExchange()).with(TransactionMessage.ROUTING_KEY);
        }
    }

    @Bean
    public RabbitTransactionManager rabbitTransactionManager(ConnectionFactory connectionFactory, RabbitTemplate rabbitTemplate) {

        // 设置 rabbitTemplate 支持事务
        rabbitTemplate.setConnectionFactory(connectionFactory);
        // 创建 RabbitTransactionManager 对象
        return new RabbitTransactionManager(connectionFactory);
    }

    @Bean
    public TransactionConsumer transactionConsumer() {
        return new TransactionConsumer();
    }

    @Bean
    public TransactionProducer transactionProducer() {
        return new TransactionProducer();
    }
}
