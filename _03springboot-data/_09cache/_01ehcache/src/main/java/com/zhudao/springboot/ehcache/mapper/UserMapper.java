package com.zhudao.springboot.ehcache.mapper;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhudao.springboot.ehcache.dataobject.UserDO;

/**
 * UserMapper
 *
 * - @CacheConfig 在类级别指定缓存的一些默认配置, 如 指定缓存名称 方法中不需要额外指定缓存名
 *
 * @Description: UserMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 15:21
 */
@Repository
@CacheConfig(cacheNames = "users")
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * -@Cacheable: 添加在方法上 缓存方法的执行结果;
     *              如果缓存中有 key为id的数据直接取, 否则将方法的执行结果存入缓存
     */
    @Cacheable(key = "#id")
    UserDO selectById(Integer id);

    @CachePut(key = "#user.id")
    default UserDO insert0(UserDO user) {
        this.insert(user);
        return user;
    }

    @CacheEvict(key = "#id")
    int deleteById(Integer id);

}
