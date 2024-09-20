package com.zhudao.springboot.sharding.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ShardingDatasourceApplication
 *
 * @Description: ShardingDatasourceApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 9:29
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhudao.springboot.sharding.datasource.mapper")
public class ShardingDatasourceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShardingDatasourceApplication.class, args);
    }
}
