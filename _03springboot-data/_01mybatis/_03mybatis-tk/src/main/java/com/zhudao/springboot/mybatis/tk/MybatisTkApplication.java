package com.zhudao.springboot.mybatis.tk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MybatisTkApplication
 *
 * @Description: MybatisTkApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 14:49
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhudao.springboot.mybatis.tk.mapper")
public class MybatisTkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisTkApplication.class, args);
    }
}
