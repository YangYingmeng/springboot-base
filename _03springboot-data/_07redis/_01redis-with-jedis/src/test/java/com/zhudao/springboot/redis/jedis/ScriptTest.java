package com.zhudao.springboot.redis.jedis;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ScriptTest
 *
 * @Description: ScriptTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScriptTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01() throws IOException {
        // 读取 /resources/lua/compareAndSet.lua
        String scriptContents = IOUtils.toString(getClass()
                .getResourceAsStream("/lua/compareAndSet.lua"), "UTF-8");
        // 创建redisScript对象
        RedisScript<Long> script = new DefaultRedisScript<>(scriptContents, Long.class);
        // 执行LUA脚本
        Long result = stringRedisTemplate.execute(script, Collections.singletonList("zhudao:1"), "lua", "script");
        System.out.println(result);
    }

    @Test
    public void test02() throws IOException {
        String scriptContents = IOUtils.toString(getClass()
                .getResourceAsStream("/lua/test.lua"), "UTF-8");
        RedisScript<List> script = new DefaultRedisScript<>(scriptContents, List.class);
        List<Object> result = stringRedisTemplate.execute(script, Arrays.asList("key1", "key2"), "first", "second");
        System.out.println(result);
    }
}
