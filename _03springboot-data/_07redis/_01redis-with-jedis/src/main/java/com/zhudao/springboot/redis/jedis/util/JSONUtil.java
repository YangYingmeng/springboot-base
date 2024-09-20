package com.zhudao.springboot.redis.jedis.util;

import com.alibaba.fastjson.JSON;

/**
 * JSONUtil
 *
 * @Description: JSONUtil
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 14:37
 */
public class JSONUtil {

    public static  <T> T parseObject(String text, Class<T> clazz) {

        return JSON.parseObject(text, clazz);
    }

    public static String toJSONString(Object javaObject) {

        return JSON.toJSONString(javaObject);
    }

    public static byte[] toJSONBytes(Object javaObject) {

        return JSON.toJSONBytes(javaObject);
    }
}
