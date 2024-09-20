package com.zhudao.springboot.ehcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * EhcacheApplication
 *
 * @Description: EhcacheApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 14:47
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.zhudao.springboot.ehcache.mapper")
public class EhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhcacheApplication.class, args);
    }
}
