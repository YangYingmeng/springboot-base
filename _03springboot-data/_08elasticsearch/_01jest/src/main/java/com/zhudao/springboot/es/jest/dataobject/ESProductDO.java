package com.zhudao.springboot.es.jest.dataobject;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.zhudao.springboot.es.jest.constant.FieldAnalyzer;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ESProductDO
 *
 * @Description: ESProductDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 10:07
 */
@Document(indexName = "product",
        type = "product",
        shards = 1,
        replicas = 0,
        refreshInterval = "-1")
@Data
@Accessors(chain = true)
public class ESProductDO {

    /**
     * ID 主键
     */
    @Id
    private Integer id;

    /**
     * SPU 名字
     */
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String name;
    /**
     * 卖点
     */
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String sellPoint;
    /**
     * 描述
     */
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String description;
    /**
     * 分类编号
     */
    private Integer cid;
    /**
     * 分类名
     */
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String categoryName;

}
