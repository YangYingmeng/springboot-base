package com.zhudao.springboot.dynamic.datasource.baomidou.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhudao.springboot.dynamic.datasource.baomidou.constant.DBConstants;
import com.zhudao.springboot.dynamic.datasource.baomidou.dataobject.UserDO;

/**
 * UserMapper
 *
 * @Description: UserMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/22 15:14
 */
@Repository
@DS(DBConstants.DATASOURCE_USERS)
public interface UserMapper {

    UserDO selectById(@Param("id") Integer id);
}
