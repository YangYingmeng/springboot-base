package com.zhudao.springboot.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ValidationApplication
 *
 * @Description: ValidationApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/12 16:31
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class ValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationApplication.class, args);
    }
}
