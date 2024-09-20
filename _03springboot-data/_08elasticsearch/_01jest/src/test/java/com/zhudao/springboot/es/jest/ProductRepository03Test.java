package com.zhudao.springboot.es.jest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.es.jest.dataobject.ESProductDO;
import com.zhudao.springboot.es.jest.repository.ProductRepository03;

/**
 * ProductRepository03Test
 *
 * @Description: ProductRepository03Test
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 13:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsJestApplication.class)
public class ProductRepository03Test {

    @Resource
    private ProductRepository03 productRepository03;

    @Test
    public void testSearch() {
        // 查找分类为 1 + 指定关键字，并且按照 id 升序
        Page<ESProductDO> page = productRepository03.search(1, "技术",
                PageRequest.of(0, 5, Sort.Direction.ASC, "id"));
        System.out.println(page.getTotalPages());

        // 查找分类为 1 ，并且按照 id 升序
        page = productRepository03.search(1, null,
                PageRequest.of(0, 5, Sort.Direction.ASC, "id"));
        System.out.println(page.getTotalPages());
    }

}
