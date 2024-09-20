package com.zhudao.springboot.mvc.service;

import org.springframework.stereotype.Service;

import com.zhudao.springboot.mvc.vo.UserVO;

/**
 * @Description: UserService
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 9:45
 */
@Service
public class UserService {

    public UserVO get(Integer id) {

        return new UserVO().setId(id);
    }
}
