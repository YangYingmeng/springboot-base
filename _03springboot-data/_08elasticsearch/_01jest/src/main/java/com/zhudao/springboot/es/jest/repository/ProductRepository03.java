package com.zhudao.springboot.es.jest.repository;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.util.StringUtils;

import com.zhudao.springboot.es.jest.dataobject.ESProductDO;

/**
 * ProductRepository03
 *
 * @Description: ProductRepository03
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/28 10:16
 */
public interface ProductRepository03 extends ElasticsearchRepository<ESProductDO, Integer> {

    default Page<ESProductDO> search(Integer cid, String keyword, Pageable pageable) {

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        // 筛选条件 cid
        if (cid != null) {
            nativeSearchQueryBuilder.withFilter(QueryBuilders.termQuery("cid", cid));
        }
        // 筛选
        if (StringUtils.hasText(keyword)) {
            FunctionScoreQueryBuilder.FilterFunctionBuilder[] functions = {
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(matchQuery("name", keyword),
                            ScoreFunctionBuilders.weightFactorFunction(10)),
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(matchQuery("sellPoint", keyword),
                            ScoreFunctionBuilders.weightFactorFunction(2)),
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(matchQuery("categoryName", keyword),
                            ScoreFunctionBuilders.weightFactorFunction(3)),
            };
            FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(functions)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                    .setMinScore(2F);
            nativeSearchQueryBuilder.withQuery(functionScoreQueryBuilder);
        }
        // 排序
        if (StringUtils.hasText(keyword)) {
            nativeSearchQueryBuilder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC));
        } else if (pageable.getSort().isSorted()) {
            pageable.getSort().get().forEach(sortField -> nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort(sortField.getProperty())
                    .order(sortField.getDirection().isAscending() ? SortOrder.ASC : SortOrder.DESC)));
        } else {
            // 无排序, 按照ID倒序
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
        }
        // 分页
        nativeSearchQueryBuilder.withPageable(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
        // 执行查询
        return search(nativeSearchQueryBuilder.build());
    }

}
