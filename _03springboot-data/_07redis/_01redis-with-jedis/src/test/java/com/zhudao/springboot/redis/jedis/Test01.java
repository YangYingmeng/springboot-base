package com.zhudao.springboot.redis.jedis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test01
 *
 * @Description: Test01
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 14:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringSetKey() {

        stringRedisTemplate.opsForValue().set("zhudao", "testStringSetKey");
    }

    @Test
    public void testStringFormat() {
        String KEY_PATTERN = "user+%d";
        System.out.println(String.format(KEY_PATTERN, 1));
    }
}
