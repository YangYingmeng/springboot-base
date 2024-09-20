package com.zhudao.springboot.hikaricp.single;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * HikaricpSingleApplication
 *
 * @Description: HikaricpSingleApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 9:46
 */
@SpringBootApplication
public class HikaricpSingleApplication implements CommandLineRunner {

    @Resource
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(HikaricpSingleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("[run][获得连接: " + connection + "]");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
