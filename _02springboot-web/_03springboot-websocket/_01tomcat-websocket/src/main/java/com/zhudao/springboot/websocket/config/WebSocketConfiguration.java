package com.zhudao.springboot.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Description: WebSocketConfiguration
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 15:27
 */
@Configuration
public class WebSocketConfiguration {

    /**
     * 该bean的作用是扫描并找到@ServerEndpoint标记的服务站点
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }
}
