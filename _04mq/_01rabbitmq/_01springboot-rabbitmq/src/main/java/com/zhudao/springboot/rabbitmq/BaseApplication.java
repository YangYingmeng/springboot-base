package com.zhudao.springboot.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * BaseApplication
 *
 * @Description: BaseApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 9:57
 */
@SpringBootApplication
@EnableAsync
public class BaseApplication {

    public static void main(String[] args) {

        SpringApplication.run(BaseApplication.class, args);
    }
}
