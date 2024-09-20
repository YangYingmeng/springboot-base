package com.zhudao.springboot.redis.redisson.cacheobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserCacheObject
 *
 * @Description: UserCacheObject
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 17:11
 */
@Data
@Accessors(chain = true)
public class UserCacheObject {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;
}
