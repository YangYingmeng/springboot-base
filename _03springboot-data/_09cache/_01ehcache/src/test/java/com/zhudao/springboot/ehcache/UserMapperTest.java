package com.zhudao.springboot.ehcache;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.ehcache.dataobject.UserDO;
import com.zhudao.springboot.ehcache.mapper.UserMapper;

/**
 * UserMapperTest
 *
 * @Description: UserMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 16:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EhcacheApplication.class)
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
        UserDO user = userMapper.selectById(1);
        System.out.println("user：" + user);
        Assert.assertNotNull("缓存为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));
        Cache.ValueWrapper valueWrapper = cacheManager.getCache(CACHE_NAME_USER).get(user.getId());
        UserDO cacheUser = (UserDO) valueWrapper.get();
        System.out.println("cacheUser: " + cacheUser);
        // 查询 id = 1 的记录
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
        // 插入记录，为了让缓存里有记录
        UserDO user = new UserDO();
        user.setUsername(UUID.randomUUID().toString()); // 随机账号，因为唯一索引
        user.setPassword("nicai");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userMapper.insert0(user);
        // 判断缓存中，是不是存在
        Assert.assertNotNull("缓存为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));

        // 删除记录，为了让缓存被删除
        userMapper.deleteById(user.getId());
        // 判断缓存中，是不是存在
        Assert.assertNull("缓存不为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));
    }

}
