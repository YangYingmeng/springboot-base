package com.zhudao.springboot.sharding.datasource.readwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ShardingDatasourceRWApplication
 *
 * @Description: ShardingDatasourceRWApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 10:56
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhudao.springboot.sharding.datasource.readwrite.mapper")
public class ShardingDatasourceRWApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShardingDatasourceRWApplication.class, args);
    }
}
