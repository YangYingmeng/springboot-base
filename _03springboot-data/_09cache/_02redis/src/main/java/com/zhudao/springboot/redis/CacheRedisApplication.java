package com.zhudao.springboot.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * CacheRedisApplication
 *
 * @Description: CacheRedisApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 17:17
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "")
public class CacheRedisApplication {
}
