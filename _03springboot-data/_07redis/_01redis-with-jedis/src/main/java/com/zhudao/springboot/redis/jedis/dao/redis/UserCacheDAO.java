package com.zhudao.springboot.redis.jedis.dao.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.zhudao.springboot.redis.jedis.cacheobject.UserCacheObject;
import com.zhudao.springboot.redis.jedis.util.JSONUtil;

/**
 * UserCacheDAO
 *
 * @Description: UserCacheDAO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 14:28
 */
@Repository
public class UserCacheDAO {

    // user: 用户编号
    private static final String KEY_PATTERN = "user:%d";

    @Resource(name = "redisTemplate")
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ValueOperations<String, String> operations;

    private static String buildKey(Integer id) {
        // 替换字符串模板
        return String.format(KEY_PATTERN, id);
    }

    public UserCacheObject get(Integer id) {

        String key = buildKey(id);
        String vale = operations.get(key);
        return JSONUtil.parseObject(vale, UserCacheObject.class);
    }

    public void set(Integer id, UserCacheObject object) {

        String key = buildKey(id);
        String value = JSONUtil.toJSONString(object);
        operations.set(key, value);
    }
}
