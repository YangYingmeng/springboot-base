package com.zhudao.springboot.rabbitmq.base;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.rabbitmq.BaseApplication;
import com.zhudao.springboot.rabbitmq._01base.producer.TopicProducer;

import lombok.extern.slf4j.Slf4j;

/**
 * TopicProducerTest
 *
 * @Description: TopicProducerTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:41
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class _01TopicProducerTest {

    @Resource
    private TopicProducer producer;

    @Test
    public void testSyncSendSuccess() throws InterruptedException {

        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id, "da.zhu.dao");
        log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSendFailure() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id, "yu.zhu.bao");
        log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
