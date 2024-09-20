package com.zhudao.springboot.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/9/5 17:26
 */
@SpringBootApplication
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
        System.out.println("*** ActuatorApplication start ***");
    }
}
