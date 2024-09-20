package com.zhudao.springboot.dynamic.datasource.sharding.readwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ShardingRWApplication
 *
 * @Description: ShardingRWApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/26 16:39
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhudao.springboot.dynamic.datasource.sharding.readwrite.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class ShardingRWApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingRWApplication.class, args);
    }
}
