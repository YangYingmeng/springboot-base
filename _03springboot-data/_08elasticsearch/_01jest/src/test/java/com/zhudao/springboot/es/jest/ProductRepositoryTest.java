package com.zhudao.springboot.es.jest;

import java.util.Arrays;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.es.jest.dataobject.ESProductDO;
import com.zhudao.springboot.es.jest.repository.ProductRepository;

/**
 * ProductRepositoryTest
 * jest基础api测试
 *
 * @Description: ProductRepositoryTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 10:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsJestApplication.class)
public class ProductRepositoryTest {

    @Resource
    private ProductRepository productRepository;

    @Test
    public void testInsert() {
        // 一般 ES 的 ID 编号，使用 DB 数据对应的编号。这里，先写死
        ESProductDO product = new ESProductDO().setId(1)
                .setName("逐道")
                .setSellPoint("十年运到龙困井, 一朝得势入青云")
                .setDescription("des")
                .setCid(1)
                .setCategoryName("es-jest");
        productRepository.save(product);
    }

    /**
     * 这里要注意，如果使用 save 方法来更新的话，必须是全量字段，否则其它字段会被覆盖。
     */
    @Test
    public void testUpdate() {
        ESProductDO product = new ESProductDO().setId(1)
                .setName("逐道")
                .setSellPoint("十年运到龙困井, 一朝得势入青云")
                .setDescription("update")
                .setCid(1)
                .setCategoryName("es-jest");
        productRepository.save(product);
    }


    /**
     * 根据 ID 编号，删除一条记录
     */
    @Test
    public void testDelete() {
        productRepository.deleteById(1);
    }


    /**
     * 根据 ID 编号，查询一条记录
     */
    @Test
    public void testSelectById() {

        Optional<ESProductDO> userDO = productRepository.findById(1);
        System.out.println(userDO.isPresent());
    }


    /**
     * 根据 ID 编号数组，查询多条记录
     */
    @Test
    public void testSelectByIds() {

        Iterable<ESProductDO> users = productRepository.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }
}
