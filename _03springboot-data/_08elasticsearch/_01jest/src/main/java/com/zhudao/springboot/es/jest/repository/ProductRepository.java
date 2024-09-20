package com.zhudao.springboot.es.jest.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zhudao.springboot.es.jest.dataobject.ESProductDO;

/**
 * ProductRepository
 * 实体类 主键类型
 * @Description: ProductRepository
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 10:11
 */
public interface ProductRepository extends ElasticsearchRepository<ESProductDO, Integer> {
}
