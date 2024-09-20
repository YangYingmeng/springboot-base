package com.zhudao.springboot.druid.single;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * DruidSingleApplication
 * http://127.0.0.1:8080/druid 访问监控页面
 *
 * @Description: DruidSingleApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 11:03
 */
@Slf4j
@SpringBootApplication
public class DruidSingleApplication implements CommandLineRunner {

    @Resource
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DruidSingleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("[run][获得数据源：{}]", dataSource.getClass());
    }
}
