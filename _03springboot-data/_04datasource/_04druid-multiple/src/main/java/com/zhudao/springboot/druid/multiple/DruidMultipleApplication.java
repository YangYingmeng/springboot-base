package com.zhudao.springboot.druid.multiple;

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
public class DruidMultipleApplication implements CommandLineRunner {

    @Resource(name = "ordersDataSource")
    private DataSource ordersDataSource;

    @Resource(name = "usersDataSource")
    private DataSource usersDataSource;

    public static void main(String[] args) {
        SpringApplication.run(DruidMultipleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // orders 数据源
        log.info("[run][获得数据源：{}]", ordersDataSource.getClass());

        // users 数据源
        log.info("[run][获得数据源：{}]", usersDataSource.getClass());
    }
}
