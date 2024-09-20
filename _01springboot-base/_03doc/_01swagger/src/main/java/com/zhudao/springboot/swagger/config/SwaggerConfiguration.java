package com.zhudao.springboot.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 自行拓展 结合yApi使用
 * @Description: SwaggerConfiguration
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 15:51
 */
@Configuration
@EnableSwagger2 // 标记项目启用 Swagger API 接口文档
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        // 创建 Docket 对象
        return new Docket(DocumentationType.SWAGGER_2) // 文档类型，使用 Swagger2
                .apiInfo(this.apiInfo()) // 设置 API 信息
                // 扫描 Controller 包路径，获得 API 接口
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhudao.springboot.swagger.controller"))
                .paths(PathSelectors.any())
                // 构建出 Docket 对象
                .build();
    }

    /**
     * 创建API信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("逐道-接口文档测试")
                .description("逐有道无术之道")
                .version("1.0.0")
                .contact(new Contact("逐道", null, "769212304@qq.com"))
                .build();
    }
}
