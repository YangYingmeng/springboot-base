package com.zhudao.springboot.validation.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhudao.springboot.validation.dto.UserAddDTO;
import com.zhudao.springboot.validation.dto.UserUpdateDTO;
import com.zhudao.springboot.validation.dto.UserUpdateGenderDTO;
import com.zhudao.springboot.validation.dto.UserUpdateStatusDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * UserController
 *
 * @Description: UserController
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/12 16:41
 */
@RestController
@RequestMapping("/users")
@Validated // 声明式注解, 表示该类所有接口都需要进行参数校验
@Slf4j
public class UserController {

    @GetMapping("/get")
    public void get(@RequestParam("id") @Min(value = 1L, message = "编号必须大于 0") Integer id) {

        log.info("[get][id: {}]", id);
    }

    @PostMapping("/add")
    public void add(@Valid UserAddDTO addDTO) {

        log.info("[add][addDTO: {}]", addDTO);
    }

    @PostMapping("/update")
    public void update(@Valid UserUpdateDTO updateDTO) {

        log.info("[update][updateDTO: {}]", updateDTO);
    }

    @PostMapping("/update_gender")
    public void updateGender(@Valid UserUpdateGenderDTO updateGenderDTO) {
        log.info("[updateGender][updateGenderDTO: {}]", updateGenderDTO);
    }

    @PostMapping("/update_status_false")
    public void updateStatusFalse(@Validated(UserUpdateStatusDTO.Group02.class) UserUpdateStatusDTO updateStatusDTO) {
        log.info("[updateStatusFalse][updateStatusDTO: {}]", updateStatusDTO);
    }

}
