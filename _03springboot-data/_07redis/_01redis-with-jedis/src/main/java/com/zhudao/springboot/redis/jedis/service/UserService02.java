package com.zhudao.springboot.redis.jedis.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhudao.springboot.redis.jedis.cacheobject.UserCacheObject;
import com.zhudao.springboot.redis.jedis.dao.redis.UserCacheDAO;

/**
 * UserService02
 *
 * @Description: UserService02
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 14:41
 */
@Service
public class UserService02 {

    @Resource
    private UserCacheDAO userCacheDAO;

    public UserCacheObject get(Integer id) {

        return userCacheDAO.get(id);
    }

    public void set(Integer id, UserCacheObject object) {

        userCacheDAO.set(id, object);
    }
}
