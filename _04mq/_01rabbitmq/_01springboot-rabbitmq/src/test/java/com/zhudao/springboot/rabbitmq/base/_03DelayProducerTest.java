package com.zhudao.springboot.rabbitmq.base;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.rabbitmq.BaseApplication;
import com.zhudao.springboot.rabbitmq._03delay.producer.DelayProducer;

import lombok.extern.slf4j.Slf4j;

/**
 * 延迟机制测试
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 18:27
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class _03DelayProducerTest {

    @Resource
    private DelayProducer producer;

    @Test
    public void testSyncSend01() throws InterruptedException {
        // 不设置消息的过期时间，使用队列默认的消息过期时间
        this.testSyncSendDelay(null);
    }

    @Test
    public void testSyncSend02() throws InterruptedException {
        // 设置发送消息的过期时间为 5000 毫秒
        this.testSyncSendDelay(5000);
    }

    private void testSyncSendDelay(Integer delay) throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id, delay);
        log.info("[testSyncSendDelay][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
