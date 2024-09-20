package com.zhudao.springboot.webflux.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhudao.springboot.webflux.service.UserService;
import com.zhudao.springboot.webflux.vo.UserVO;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 基于 Annotated Controller 方式实现
 *
 * @Description: UserController
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 13:49
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public Flux<UserVO> list() {

        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("1"));
        result.add(new UserVO().setId(2).setUsername("2"));
        result.add(new UserVO().setId(3).setUsername("3"));
        // 创建包含多个元素的响应流, 这些元素从Iterable对象获取
        // Iterable对象被Collection对象实现, 所以相当于是将List/Set等集合转为Flux对象
        return Flux.fromIterable(result);
    }

    @GetMapping("get")
    public Mono<UserVO> get(@RequestParam("id") Integer id) {

        UserVO user = new UserVO().setId(id).setUsername("username:" + id);
        // 创建包含单个元素的响应式流
        return Mono.just(user);
    }
}
