package com.zhudao.springboot.rabbitmq.base;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.rabbitmq.BaseApplication;
import com.zhudao.springboot.rabbitmq._04model.producer.BroadcastProducer;
import com.zhudao.springboot.rabbitmq._04model.producer.ClusteringProducer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 10:21
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
@ActiveProfiles("retry")
public class _04ModelProducerTest {

    @Resource
    private BroadcastProducer broadcastProducer;
    @Resource
    private ClusteringProducer clusteringProducer;

    @Test
    public void mock() throws InterruptedException {
        new CountDownLatch(1).await();
    }

    @Test
    public void testBroadcastSyncSend() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int id = (int) (System.currentTimeMillis() / 1000);
            broadcastProducer.syncSend(id);
            log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testClusteringSyncSend() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int id = (int) (System.currentTimeMillis() / 1000);
            clusteringProducer.syncSend(id);
            log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
