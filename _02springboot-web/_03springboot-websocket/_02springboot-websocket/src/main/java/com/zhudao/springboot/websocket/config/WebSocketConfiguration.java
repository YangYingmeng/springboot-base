package com.zhudao.springboot.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.zhudao.springboot.websocket.websocket.DemoWebSocketHandler;
import com.zhudao.springboot.websocket.websocket.DemoWebSocketShakeInterceptor;

/**
 * @Description: WebSocketConfiguration
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 15:27
 */
@Configuration
@EnableWebSocket // 开启spring webSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Bean
    public DemoWebSocketHandler webSocketHandler() {
        return new DemoWebSocketHandler();
    }

    @Bean
    public DemoWebSocketShakeInterceptor webSocketShakeInterceptor() {
        return new DemoWebSocketShakeInterceptor();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(this.webSocketHandler(), "/") // 配置处理器
                .addInterceptors(new DemoWebSocketShakeInterceptor()) // 配置拦截器
                .setAllowedOrigins("*"); // 解决跨域问题
    }
}
