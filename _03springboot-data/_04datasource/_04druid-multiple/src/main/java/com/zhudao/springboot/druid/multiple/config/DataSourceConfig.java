package com.zhudao.springboot.druid.multiple.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * DataSourceConfig
 *
 * @Description: DataSourceConfig
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 11:14
 */
@Configuration
public class DataSourceConfig {

    /**
     * ordersDataSource注入spring容器
     */
    @Primary
    @Bean(name = "ordersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.orders")
    public DataSource ordersDataSource() {

        return DruidDataSourceBuilder.create().build();
    }

    /**
     * usersDataSource注入spring容器
     */
    @Bean(name = "usersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.users")
    public DataSource usersDataSource() {

        return DruidDataSourceBuilder.create().build();
    }
}
