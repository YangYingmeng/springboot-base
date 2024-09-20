package com.zhudao.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.zhudao.springboot.jpa.dataobject.UserDO;

/**
 * UserRepository01
 *
 * @Description: UserRepository01
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 9:32
 */
public interface UserRepository01 extends CrudRepository<UserDO, Integer> {
}
