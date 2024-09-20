package com.zhudao.springboot.starter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: StarterDemoApplication
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 10:02
 * 自动装配原理:
 *      1. 配置类
 *          1.1 @Configuration: 声明配置类
 *          1.2 @ConditionOn**(xx.class): 只有xx类存在时, 配置类才生效
 *          1.3 @EnableConfigurationProperties(xxProperties.class): 使配置文件属性映射类生效
 *      2. 将配置类的类全名加入META/INF.spring.factories中
 *      3. springboot项目启动时,
 *          1. @EnableAutoConfiguration -> @Import -> selectImports方法()
 *              1. 使用SpringFactoriesLoader读取META-INF/spring.factories, 获取需要自动配置的配置类, 作为候选配置类集合,
 *                 对候选配置类进行过滤, 选出@ConditionalOnXX的所有配置类
 *              2. 返回这些需要加载到容器中的类名数组
 *
 *          2. 通过run方法用BeanDefinitionLoader加载AutoConfigurationImportSelector返回的类名数组
 */
@SpringBootApplication
public class StarterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterDemoApplication.class, args);
    }
}
