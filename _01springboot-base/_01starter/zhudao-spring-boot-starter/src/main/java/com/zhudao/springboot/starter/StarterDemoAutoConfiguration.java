package com.zhudao.springboot.starter;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.net.httpserver.HttpServer;

/**
 * @Description: StarterDemo 自动配置类
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 10:09
 */
@Configuration // 声明配置类
@EnableConfigurationProperties(StarterDemoProperties.class) // 使StarterDemoProperties生效
public class StarterDemoAutoConfiguration {

    private final Logger logger = LoggerFactory.getLogger(StarterDemoAutoConfiguration.class);

    /**
     * 服务启动时指定端口, yml就不需要配置
     * 打印yml中的文本
     */
    @Bean
    @ConditionalOnClass(HttpServer.class)
    public HttpServer httpServer(StarterDemoProperties starterDemoProperties) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.start();
        logger.info("[httpServer][启动服务器成功], 服务文案: {}", starterDemoProperties.getText());
        return server;
    }
}
