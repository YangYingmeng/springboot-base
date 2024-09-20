package com.zhudao.springboot.hikaricp.multiple.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import com.zaxxer.hikari.HikariDataSource;

/**
 * DataSourceConfig
 *
 * @Description: DataSourceConfig
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 10:07
 */
@Configuration
public class DataSourceConfig {

    /**
     * orders数据源的配置对象(url driver-class name/psw)
     */
    @Primary
    @Bean(name = "orderDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.orders")
    public DataSourceProperties orderDataSourceProperties() {

        return new DataSourceProperties();
    }

    /**
     * 创建orders数据源
     * */
    @Bean(name = "ordersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.orders.hikari")
    public DataSource ordersDataSource() {

        DataSourceProperties properties = this.orderDataSourceProperties();
        return createHikariDataSource(properties);
    }

    private DataSource createHikariDataSource(DataSourceProperties properties) {
        // 用数据源的配置对象创建数据源
        HikariDataSource hikariDataSource = properties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
        // 设置线程池名称
        if (StringUtils.hasText(properties.getName())) {
            hikariDataSource.setPoolName(properties.getName());
        }
        return hikariDataSource;
    }

    /**
     * users数据源的配置对象(url driver-class name/psw)
     */
    @Bean(name = "userDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.users")
    public DataSourceProperties userDataSourceProperties() {

        return new DataSourceProperties();
    }

    /**
     * 创建users数据源
     * */
    @Bean(name = "usersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.orders.users")
    public DataSource usersDataSource() {

        DataSourceProperties properties = this.userDataSourceProperties();
        return createHikariDataSource(properties);
    }
}
