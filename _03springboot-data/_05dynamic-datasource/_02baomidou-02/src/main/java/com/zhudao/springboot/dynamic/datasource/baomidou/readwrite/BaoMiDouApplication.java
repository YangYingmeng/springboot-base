package com.zhudao.springboot.dynamic.datasource.baomidou.readwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * BaoMiDouApplication
 *
 * @Description: BaoMiDouApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/22 14:57
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhudao.springboot.baomidou.readwrite.mapper")
@EnableAspectJAutoProxy(exposeProxy = true) // spring将代理对象设置到AopContext中
public class BaoMiDouApplication {

    public static void main(String[] args) {

        SpringApplication.run(BaoMiDouApplication.class, args);
    }
}
