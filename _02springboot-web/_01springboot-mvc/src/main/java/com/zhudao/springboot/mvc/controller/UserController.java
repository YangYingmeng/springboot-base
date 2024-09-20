package com.zhudao.springboot.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhudao.springboot.mvc.constant.ServiceExceptionEnum;
import com.zhudao.springboot.mvc.core.exception.ServiceException;
import com.zhudao.springboot.mvc.core.vo.CommonResult;
import com.zhudao.springboot.mvc.dto.UserAddDTO;
import com.zhudao.springboot.mvc.dto.UserUpdateDTO;
import com.zhudao.springboot.mvc.service.UserService;
import com.zhudao.springboot.mvc.vo.UserVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: UserController
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 9:45
 */
@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    /**
     * 查询用户列表
     */
    @GetMapping("")
    public List<UserVO> list() {

        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("1"));
        result.add(new UserVO().setId(2).setUsername("2"));
        result.add(new UserVO().setId(3).setUsername("3"));
        return result;
    }

    /**
     * 获得指定用户编号的用户
     */
    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Integer id) {

        return new UserVO().setId(id).setUsername("username:" + id);
    }

    /**
     * 获得指定用户编号的用户
     */
    @GetMapping("/v2/{id}")
    public UserVO get2(@PathVariable("id") Integer id) {

        return userService.get(id);
    }

    /**
     * 添加用户
     */
    @PostMapping("")
    public Integer add(UserAddDTO addDTO) {

        Integer returnId = 1;
        return returnId;
    }

    /**
     * 更新指定用户编号的用户
     */
    @PutMapping("/{id}")
    public Boolean update(@PathVariable("id") Integer id, UserUpdateDTO updateDTO) {

        updateDTO.setId(id);
        Boolean success = true;
        return success;
    }

    /**
     * 删除指定用户编号的用户
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {

        return false;
    }

    @GetMapping("/testCommonResult1")
    public UserVO testCommonResult1() {

        return new UserVO().setId(1).setUsername("user1");
    }

    @GetMapping("/testCommonResult2")
    public CommonResult<UserVO> testCommonResult2() {

        return CommonResult.success(new UserVO().setId(1).setUsername("user1"));
    }

    /**
     * 测试抛出 NullPointerException 异常
     */
    @GetMapping("/test-exception01")
    public UserVO exception01() {
        throw new NullPointerException("没有粗面鱼丸");
    }

    /**
     * 测试抛出 ServiceException 异常
     */
    @GetMapping("/test-exception02")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

    @GetMapping("/testInterceptor01")
    public void testInterceptor01() {
        log.info("[testInterceptor01]");
    }

    @GetMapping("/testInterceptor02")
    public UserVO testInterceptor02() {
        log.info("[testInterceptor02]");
        return new UserVO().setId(10).setUsername(UUID.randomUUID().toString());
    }

    @GetMapping("/testInterceptor03")
    public UserVO testInterceptor03() {
        log.info("[testInterceptor03]");
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }
}
