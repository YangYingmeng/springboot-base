package com.zhudao.springboot.dynamic.datasource.sharding.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhudao.springboot.dynamic.datasource.sharding.dataobject.UserDO;

/**
 * UserMapper
 *
 * @Description: UserMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/26 15:37
 */
@Repository
public interface UserMapper {

    UserDO selectById(@Param("id") Integer id);
}
