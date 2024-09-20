package com.zhudao.springboot.rabbitmq.base;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.rabbitmq.BaseApplication;
import com.zhudao.springboot.rabbitmq._06transaction.producer.TransactionProducer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/24 15:06
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class _06TransactionProducerTest {

    @Resource
    private TransactionProducer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
