package com.zhudao.springboot.mapstruct.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.zhudao.springboot.mapstruct.bo.UserBO;
import com.zhudao.springboot.mapstruct.dataobject.UserDO;

/**
 * @Description: UserConvert
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 15:27
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mapping(source = "doAge", target = "boAge")
    UserBO convert(UserDO userDO);
}
