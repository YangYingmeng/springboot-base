package com.zhudao.springboot.redis.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PubSubTest
 *
 * @Description: PubSubTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 15:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PubSubTest {

    public static final String TOPIC = "TEST";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            stringRedisTemplate.convertAndSend(TOPIC, "zhudao:" + i);
            Thread.sleep(1000L);
        }
    }

}
