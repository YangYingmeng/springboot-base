package com.zhudao.springboot.mybatis.plus.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhudao.springboot.mybatis.plus.dataobject.UserDO;

/**
 * UserMapper
 *
 * @Description: UserMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 14:08
 */
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

}
