package com.zhudao.springboot.mybatis.xml.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhudao.springboot.mybatis.xml.dataobject.UserDO;

/**
 * UserMapper 多参数时建议使用DO, 语义更为明确
 *
 * @Description: UserMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 11:21
 */
@Repository
public interface UserMapper {

    int insert(UserDO user);

    int updateById(UserDO user);

    int deleteById(@Param("id") Integer id);

    UserDO selectById(@Param("id") Integer id);

    UserDO selectByUsername(@Param("username") String username);

    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);

}
