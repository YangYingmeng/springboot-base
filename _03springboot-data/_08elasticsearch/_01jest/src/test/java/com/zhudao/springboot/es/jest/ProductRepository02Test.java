package com.zhudao.springboot.es.jest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.es.jest.dataobject.ESProductDO;
import com.zhudao.springboot.es.jest.repository.ProductRepository;
import com.zhudao.springboot.es.jest.repository.ProductRepository02;

/**
 * ProductRepository02Test
 *
 * @Description: ProductRepository02Test
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 11:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsJestApplication.class)
public class ProductRepository02Test {

    @Resource
    private ProductRepository02 productRepository;

    /**
     * 根据名字获得一条记录
     */
    @Test
    public void testFindByName() {

        ESProductDO product = productRepository.findByName("逐道");
        System.out.println(product);
    }

    /**
     * 使用 name 模糊查询，分页返回结果
     */
    @Test
    public void testFindNameLike() {

        if (true) {
            testInsert();
        }
        // 创建排序条件
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        // 创建分页条件
        Pageable pageable = PageRequest.of(0, 10, sort);
        // 执行分页操作
        Page<ESProductDO> page = productRepository.findByNameLike("逐", pageable);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }

    private void testInsert() {
        for (int i = 0; i <= 100; i++) {
            ESProductDO product = new ESProductDO().setId(i)
                    .setName("逐道" + i)
                    .setSellPoint("十年运到龙困井, 一朝得势入青云")
                    .setDescription("des")
                    .setCid(1)
                    .setCategoryName("es-jest");
        }
    }
}
