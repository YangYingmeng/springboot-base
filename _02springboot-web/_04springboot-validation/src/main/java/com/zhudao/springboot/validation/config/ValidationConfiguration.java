package com.zhudao.springboot.validation.config;

import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * ValidationConfiguration
 *
 * @Description: ValidationConfiguration
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/13 17:35
 */
@Configuration
public class ValidationConfiguration {

    @Bean
    public Validator validator(MessageSource messageSource) {

        // 创建 LocalValidatorFactoryBean 对象
        LocalValidatorFactoryBean validator = ValidationAutoConfiguration.defaultValidator();
        // 设置 messageSource 属性, 实现 i18 国际化
        validator.setValidationMessageSource(messageSource);
        return validator;
    }
}
