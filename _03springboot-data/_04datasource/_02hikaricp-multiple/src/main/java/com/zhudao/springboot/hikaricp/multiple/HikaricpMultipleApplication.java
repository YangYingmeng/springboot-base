package com.zhudao.springboot.hikaricp.multiple;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * HikaricpSingleApplication
 *
 * @Description: HikaricpSingleApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 9:46
 */
@Slf4j
@SpringBootApplication
public class HikaricpMultipleApplication implements CommandLineRunner {

    @Resource(name = "ordersDataSource")
    private DataSource ordersDataSource;

    @Resource(name = "usersDataSource")
    private DataSource usersDataSource;

    public static void main(String[] args) {
        SpringApplication.run(HikaricpMultipleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // orders 数据源
        try (Connection conn = ordersDataSource.getConnection()) {
            // 这里，可以做点什么
            log.info("[run][ordersDataSource 获得连接：{}]", conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // users 数据源
        try (Connection conn = usersDataSource.getConnection()) {
            // 这里，可以做点什么
            log.info("[run][usersDataSource 获得连接：{}]", conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
