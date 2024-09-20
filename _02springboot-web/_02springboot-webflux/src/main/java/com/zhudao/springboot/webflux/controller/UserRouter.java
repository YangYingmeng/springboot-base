package com.zhudao.springboot.webflux.controller;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.zhudao.springboot.webflux.vo.UserVO;

import reactor.core.publisher.Mono;

/**
 * 基于函数式编程方式
 *
 * @Description: UserRouter
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 14:06
 */
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> userListRouterFunction() {

        return route(GET("/users2/list"),
                new HandlerFunction<ServerResponse>() {

                    @Override
                    public Mono<ServerResponse> handle(ServerRequest request) {
                        List<UserVO> result = new ArrayList<>();
                        result.add(new UserVO().setId(1).setUsername("1"));
                        result.add(new UserVO().setId(2).setUsername("2"));
                        result.add(new UserVO().setId(3).setUsername("3"));
                        return ok().bodyValue(result);
                    }
                });
    }

    @Bean
    public RouterFunction<ServerResponse> userGetRouterFunction() {

        return route(GET("/users2/get"),
                new HandlerFunction<ServerResponse>() {

                    @Override
                    public Mono<ServerResponse> handle(ServerRequest request) {
                        // 获得编号
                        Integer id = request.queryParam("id")
                                .map(s -> StringUtils.isEmpty(s) ? null : Integer.valueOf(s)).get();
                        // 查询用户
                        UserVO user = new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
                        // 返回列表
                        return ok().bodyValue(user);
                    }

                });
    }

    @Bean
    public RouterFunction<ServerResponse> demoRouterFunction() {
        return route(GET("/users2/demo"), request -> ok().bodyValue("demo"));
    }
}
