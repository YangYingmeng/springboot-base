package com.zhudao.springboot.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MybatisPlusApplication
 *
 * @Description: MybatisPlusApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 14:01
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhudao.springboot.mybatis.plus.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
