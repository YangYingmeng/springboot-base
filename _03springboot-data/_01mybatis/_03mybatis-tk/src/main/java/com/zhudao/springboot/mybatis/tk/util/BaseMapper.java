package com.zhudao.springboot.mybatis.tk.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * BaseMapper
 *
 * @Description: BaseMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 14:52
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
