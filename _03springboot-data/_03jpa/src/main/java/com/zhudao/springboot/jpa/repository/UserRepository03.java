package com.zhudao.springboot.jpa.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhudao.springboot.jpa.dataobject.UserDO;

/**
 * UserRepository03
 *
 * @Description: UserRepository03
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 9:33
 */
public interface UserRepository03 extends PagingAndSortingRepository<UserDO, Integer> {

    UserDO findByUserName(String userName);

    Page<UserDO> findByCreateTimeAfter(Date createTime, Pageable pageable);
}
