package com.zhudao.springboot.mybatis.tk.mapper;

import org.springframework.stereotype.Repository;

import com.zhudao.springboot.mybatis.tk.dataobject.UserDO;
import com.zhudao.springboot.mybatis.tk.util.BaseMapper;

/**
 * UserMapper
 *
 * @Description: UserMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 14:55
 */
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

}
