package com.zhudao.springboot.redis;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.redis.dataobject.UserDO;
import com.zhudao.springboot.redis.mapper.UserMapper;

/**
 * UserMapperTest
 *
 * @Description: UserMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 17:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CacheRedisApplication.class)
public class UserMapperTest {

    private static final String CACHE_NAME_USER = "users";

    @Resource
    private UserMapper userMapper;

    @Resource
    private CacheManager cacheManager;


    @Test
    public void testCacheManager() {
        System.out.println(cacheManager);
    }

    @Test
    public void testSelectById() {

        Integer id = 1;
        UserDO user = userMapper.selectById(id);
        System.out.println("user：" + user);
        Assert.assertNotNull("缓存为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));
        user = userMapper.selectById(id);
        System.out.println("user：" + user);
    }

    @Test
    public void testInsert() {

        UserDO user = new UserDO();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword("nicai");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userMapper.insert0(user);
        Assert.assertNotNull("缓存为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));
    }

    @Test
    public void testDeleteById() {

        UserDO user = new UserDO();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword("nicai");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userMapper.insert0(user);
        Assert.assertNotNull("缓存为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));
        userMapper.deleteById(user.getId());
        Assert.assertNull("缓存不为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));
    }

}
