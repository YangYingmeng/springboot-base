package com.zhudao.springboot.druid.single.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.stat.DruidStatManagerFacade;

/**
 * DruidStatController
 *
 * @Description: DruidStatController
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/21 11:07
 */
@RestController
public class DruidStatController {

    @GetMapping("/monitor/druid/stat")
    @Deprecated
    public Object druidStat(){
        // `DruidStatManagerFacade#getDataSourceStatDataList()` 方法，可以获取所有数据源的监控数据。
        // 除此之外，DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
