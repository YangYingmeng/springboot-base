package com.zhudao.springboot.redis.jedis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.zhudao.springboot.redis.jedis.listener.TestChannelTopicMessageListener;
import com.zhudao.springboot.redis.jedis.listener.TestPatternTopicMessageListener;

/**
 * RedisConfiguration
 *
 * @Description: RedisConfiguration
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 14:13
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        // 创建 RedisTemplate 对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 开启事务
        template.setEnableTransactionSupport(true);
        // 设置redisConnectionFactory工厂
        template.setConnectionFactory(factory);
        // 使用String序列化方式, 序列化 KEY
        template.setKeySerializer(RedisSerializer.string());
        // 使用JSON序列化方式(Jackson), 序列化value 实际使用中 用序列化工具, 指定需要的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        // 自定义value的序列化方式
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();// <1>
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    @Bean
    public RedisMessageListenerContainer listenerContainer(RedisConnectionFactory factory) {

        // 创建 RedisMessageListenerContainer 对象
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        // 设置 RedisConnection 工厂。
        container.setConnectionFactory(factory);
        // 添加监听器
        container.addMessageListener(new TestChannelTopicMessageListener(), new ChannelTopic("TEST"));
        container.addMessageListener(new TestChannelTopicMessageListener(), new ChannelTopic("AOTEMAN"));
        container.addMessageListener(new TestPatternTopicMessageListener(), new PatternTopic("TEST"));
        return container;
    }
}
