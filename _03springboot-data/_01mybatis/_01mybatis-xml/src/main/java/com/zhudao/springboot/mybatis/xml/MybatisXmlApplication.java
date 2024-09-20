package com.zhudao.springboot.mybatis.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MybatisXmlApplication
 *
 * @Description: MybatisXmlApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 11:10
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhudao.springboot.mybatis.xml.mapper")
public class MybatisXmlApplication {

    public static void main(String[] args) {

        SpringApplication.run(MybatisXmlApplication.class, args);
    }
}
