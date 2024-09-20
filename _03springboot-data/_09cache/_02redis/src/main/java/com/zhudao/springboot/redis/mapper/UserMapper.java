package com.zhudao.springboot.redis.mapper;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhudao.springboot.redis.dataobject.UserDO;

/**
 * UserMapper
 *
 * @Description: UserMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 17:20
 */
@Repository
@CacheConfig(cacheNames = "users")
public interface UserMapper extends BaseMapper<UserDO> {

    @Cacheable(key = "#id")
    UserDO selectById(Integer id);

    @CachePut(key = "#user.id")
    default UserDO insert0(UserDO user) {
        // 插入记录
        this.insert(user);
        // 返回用户
        return user;
    }

    @CacheEvict(key = "#id")
    int deleteById(Integer id);
}
