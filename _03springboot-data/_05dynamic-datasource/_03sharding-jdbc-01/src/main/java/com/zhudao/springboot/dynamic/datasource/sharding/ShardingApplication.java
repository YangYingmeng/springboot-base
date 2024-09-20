package com.zhudao.springboot.dynamic.datasource.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ShardingApplication
 *
 * @Description: ShardingApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/26 15:29
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true) // http://www.voidcn.com/article/p-zddcuyii-bpt.html
@MapperScan(basePackages = "com.zhudao.springboot.dynamic.datasource.sharding.mapper")
public class ShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }
}
