package com.zhudao.springboot.rabbitmq._04model.config;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._04model.consumer.BroadcastConsumer;
import com.zhudao.springboot.rabbitmq._04model.consumer.ClusteringConsumer;
import com.zhudao.springboot.rabbitmq._04model.message.BroadcastMessage;
import com.zhudao.springboot.rabbitmq._04model.message.ClusteringMessage;
import com.zhudao.springboot.rabbitmq._04model.producer.BroadcastProducer;
import com.zhudao.springboot.rabbitmq._04model.producer.ClusteringProducer;

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
public class ModelRabbitConfig {


    /**
     * 广播消费配置, 绑定用注解的形式实现
     */
    public static class BroadcastingConfiguration {

        @Bean
        public TopicExchange broadcastingExchange() {
            return ExchangeBuilder.topicExchange(BroadcastMessage.EXCHANGE)
                    .durable(true)
                    .build();
        }
    }


    /**
     * 集群消费配置, 绑定用注解的形式实现
     */
    public static class ClusteringConfiguration {

        @Bean
        public TopicExchange clusteringExchange() {
            return ExchangeBuilder.topicExchange(ClusteringMessage.EXCHANGE)
                    .durable(true)
                    .build();
        }
    }

    @Bean
    public BroadcastConsumer broadcastConsumer() {
        return new BroadcastConsumer();
    }
    @Bean
    public BroadcastProducer broadcastProducer() {
        return new BroadcastProducer();
    }


    @Bean
    public ClusteringConsumer clusteringConsumer() {
        return new ClusteringConsumer();
    }
    @Bean
    public ClusteringProducer clusteringProducer() {
        return new ClusteringProducer();
    }
}
