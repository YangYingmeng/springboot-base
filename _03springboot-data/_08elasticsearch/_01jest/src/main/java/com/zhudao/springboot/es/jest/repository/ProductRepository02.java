package com.zhudao.springboot.es.jest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zhudao.springboot.es.jest.dataobject.ESProductDO;

/**
 * ProductRepository02
 *
 * @Description: ProductRepository02
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 10:15
 */
public interface ProductRepository02 extends ElasticsearchRepository<ESProductDO, Integer> {

    ESProductDO findByName(String name);

    Page<ESProductDO> findByNameLike(String name, Pageable pageable);
}
