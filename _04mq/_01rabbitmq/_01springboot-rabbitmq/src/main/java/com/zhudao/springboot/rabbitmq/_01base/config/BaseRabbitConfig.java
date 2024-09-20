package com.zhudao.springboot.rabbitmq._01base.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.batch.BatchingStrategy;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import com.zhudao.springboot.rabbitmq._01base.consumer.DirectBatchConsumeMsgConsumer;
import com.zhudao.springboot.rabbitmq._01base.consumer.DirectBatchSendMsgConsumer;
import com.zhudao.springboot.rabbitmq._01base.consumer.DirectConsumer;
import com.zhudao.springboot.rabbitmq._01base.consumer.FanoutConsumerA;
import com.zhudao.springboot.rabbitmq._01base.consumer.FanoutConsumerB;
import com.zhudao.springboot.rabbitmq._01base.consumer.TopicConsumer;
import com.zhudao.springboot.rabbitmq._01base.message.Message01Direct;
import com.zhudao.springboot.rabbitmq._01base.message.Message02Topic;
import com.zhudao.springboot.rabbitmq._01base.message.Message03Fanout;
import com.zhudao.springboot.rabbitmq._01base.message.Message04Batch;
import com.zhudao.springboot.rabbitmq._01base.message.Message05Batch;
import com.zhudao.springboot.rabbitmq._01base.producer.DirectBatchConsumeMsgProducer;
import com.zhudao.springboot.rabbitmq._01base.producer.DirectBatchSendMsgProducer;
import com.zhudao.springboot.rabbitmq._01base.producer.DirectProducer;
import com.zhudao.springboot.rabbitmq._01base.producer.FanoutProducer;
import com.zhudao.springboot.rabbitmq._01base.producer.TopicProducer;

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
public class BaseRabbitConfig {

    /**
     * Direct Exchange 配置
     */
    public static class DirectExchangeConfiguration {

        /**
         * 创建Queue
         */
        @Bean
        public Queue directQueue() {
            return QueueBuilder.durable(Message01Direct.QUEUE)
                    //.autoDelete() // 队列在没有消费者时, 自动删除
                    //.exclusive() // 队列只能被 Message01Direct.QUEUE 连接使用
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public DirectExchange directExchange() {
            return ExchangeBuilder.directExchange(Message01Direct.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding
         */
        @Bean
        public Binding directBinding() {
            return BindingBuilder.bind(directQueue())
                    .to(directExchange()).with(Message01Direct.ROUTING_KEY);
        }
    }


    /**
     * Topic Exchange 配置
     */
    public static class TopicExchangeConfiguration {

        /**
         * 创建Queue
         */
        @Bean
        public Queue topicQueue() {
            return QueueBuilder.durable(Message02Topic.QUEUE)
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public TopicExchange topicExchange() {
            return ExchangeBuilder.topicExchange(Message02Topic.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding
         */
        @Bean
        public Binding topicBinding() {
            return BindingBuilder.bind(topicQueue())
                    .to(topicExchange()).with(Message02Topic.ROUTING_KEY);
        }
    }


    /**
     * Fanout Exchange 配置
     */
    public static class FanoutExchangeConfiguration {

        /**
         * 创建Queue_A
         */
        @Bean
        public Queue fanoutQueueA() {
            return QueueBuilder.durable(Message03Fanout.QUEUE_A)
                    .build();
        }

        /**
         * 创建Queue_B
         */
        @Bean
        public Queue fanoutQueueB() {
            return QueueBuilder.durable(Message03Fanout.QUEUE_B)
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public FanoutExchange fanoutExchange() {
            return ExchangeBuilder.fanoutExchange(Message03Fanout.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding A-Exchange
         */
        @Bean
        public Binding fanoutBindingA() {
            return BindingBuilder.bind(fanoutQueueA())
                    .to(fanoutExchange());
        }

        /**
         * 创建Binding B-Exchange
         */
        @Bean
        public Binding fanoutBindingB() {
            return BindingBuilder.bind(fanoutQueueB())
                    .to(fanoutExchange());
        }
    }


    /**
     * Direct Exchange 批量发送配置
     */
    public static class DirectExchangeBatchConfiguration {

        /**
         * 创建Queue
         */
        @Bean
        public Queue directBatchQueue() {
            return QueueBuilder.durable(Message04Batch.QUEUE)
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public DirectExchange directBatchExchange() {
            return ExchangeBuilder.directExchange(Message04Batch.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding
         */
        @Bean
        public Binding directBatchBinding() {
            return BindingBuilder.bind(directBatchQueue())
                    .to(directBatchExchange()).with(Message04Batch.ROUTING_KEY);
        }

        @Bean
        public BatchingRabbitTemplate batchingRabbitTemplate(ConnectionFactory connectionFactory) {

            int batchSize = 16384;
            int bufferLimit = 33445566;
            long timeout = 30000;
            BatchingStrategy batchingStrategy = new SimpleBatchingStrategy(batchSize, bufferLimit, timeout);

            // 创建TaskScheduler 对象, 实现超时发送的定时器
            TaskScheduler taskScheduler = new ConcurrentTaskScheduler();
            BatchingRabbitTemplate rabbitTemplate = new BatchingRabbitTemplate(batchingStrategy, taskScheduler);
            rabbitTemplate.setConnectionFactory(connectionFactory);
            return rabbitTemplate;
        }


    }


    /**
     * Direct Exchange 批量消费配置
     */
    public static class DirectExchangeBatchConsumeConfiguration {

        /**
         * 创建Queue
         */
        @Bean
        public Queue directBatchConsumeQueue() {
            return QueueBuilder.durable(Message05Batch.QUEUE)
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public DirectExchange directBatchConsumeExchange() {
            return ExchangeBuilder.directExchange(Message05Batch.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding
         */
        @Bean
        public Binding directBatchConsumeBinding() {
            return BindingBuilder.bind(directBatchConsumeQueue())
                    .to(directBatchConsumeExchange()).with(Message05Batch.ROUTING_KEY);
        }

        @Bean(name = "batchConsumeContainerFactory")
        public SimpleRabbitListenerContainerFactory consumerBatchContainerFactory(
                SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
            // 创建 SimpleRabbitListenerContainerFactory 对象
            SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
            configurer.configure(factory, connectionFactory);
            // 额外添加批量消费的属性
            factory.setBatchListener(true);
            factory.setBatchSize(10);
            factory.setReceiveTimeout(30 * 1000L);
            factory.setConsumerBatchEnabled(true);
            return factory;
        }
    }


    /**
     * 对所有的bean按照配置文件进行统一管理, 防止冲突
     */
    @Bean
    public DirectBatchConsumeMsgConsumer directBatchConsumeMsgConsumer() {
        return new DirectBatchConsumeMsgConsumer();
    }
    @Bean
    public DirectBatchConsumeMsgProducer directBatchConsumeMsgProducer() {
        return new DirectBatchConsumeMsgProducer();
    }


    @Bean
    public DirectBatchSendMsgConsumer directBatchSendMsgConsumer() {
        return new DirectBatchSendMsgConsumer();
    }
    @Bean
    public DirectBatchSendMsgProducer directBatchSendMsgProducer() {
        return new DirectBatchSendMsgProducer();
    }


    @Bean
    public DirectConsumer directConsumer() {
        return new DirectConsumer();
    }
    @Bean
    public DirectProducer directProducer() {
        return new DirectProducer();
    }


    @Bean
    public FanoutConsumerA fanoutConsumerA() {
        return new FanoutConsumerA();
    }
    @Bean
    public FanoutConsumerB fanoutConsumerB() {
        return new FanoutConsumerB();
    }
    @Bean
    public FanoutProducer fanoutProducer() {
        return new FanoutProducer();
    }


    @Bean
    public TopicConsumer topicConsumer() {
        return new TopicConsumer();
    }
    @Bean
    public TopicProducer topicProducer() {
        return new TopicProducer();
    }
}
