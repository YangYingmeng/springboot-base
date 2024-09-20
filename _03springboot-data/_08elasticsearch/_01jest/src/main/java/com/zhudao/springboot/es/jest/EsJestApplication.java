package com.zhudao.springboot.es.jest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;

/**
 * EsJestApplication
 * 需要排除自动装配类, 否则直接使用Spring Data Elasticsearch 不会使用spring data jest
 * @Description: EsJestApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 10:04
 */
@SpringBootApplication(exclude = {ElasticsearchAutoConfiguration.class,
        ElasticsearchDataAutoConfiguration.class})
public class EsJestApplication {

    public static void main(String[] args) {

        SpringApplication.run(EsJestApplication.class, args);
    }
}
