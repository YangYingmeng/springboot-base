package com.zhudao.springboot.redis.jedis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * TestChannelTopicMessageListener
 *
 * @Description: TestChannelTopicMessageListener
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 15:29
 */
public class TestChannelTopicMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {

        System.out.println("收到 ChannelTopic 消息：");
        System.out.println("线程编号：" + Thread.currentThread().getName());
        System.out.println("message：" + message);
        System.out.println("pattern：" + new String(pattern));
    }
}
