package com.zhudao.springboot.swagger.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhudao.springboot.swagger.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @Description: UserController
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 16:07
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户 API 接口")
public class UserController {

    @GetMapping("/list")
    @ApiOperation(value = "查询用户列表", notes = "目前仅仅是作为测试，所以返回用户全列表")
    public List<UserVO> list() {

        return Arrays.asList(new UserVO().setId(1L).setUsername("zhudao"),
                new UserVO().setId(2L).setUsername("zhudao2"));
    }

    @GetMapping("/get")
    @ApiOperation("获得指定用户编号的用户")
    @ApiImplicitParam(name = "id", value = "用户编号", paramType = "query", dataTypeClass = Integer.class, required = true, example = "1024")
    public UserVO get(@RequestParam("id") Long id) {

        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

}
