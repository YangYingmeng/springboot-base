package com.zhudao.springboot.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhudao.springboot.jpa.dataobject.UserDO;

/**
 * UserRepository02
 *
 * @Description: UserRepository02
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 9:33
 */
public interface UserRepository02 extends PagingAndSortingRepository<UserDO, Integer> {
}
