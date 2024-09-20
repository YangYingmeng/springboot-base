package com.zhudao.springboot.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zhudao.springboot.mvc.core.interceptor.FirstInterceptor;
import com.zhudao.springboot.mvc.core.interceptor.SecondInterceptor;
import com.zhudao.springboot.mvc.core.interceptor.ThirdInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: SpringMVCConfiguration
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 10:47
 */
@Slf4j
@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Bean
    public FirstInterceptor firstInterceptor() {

        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor() {

        return new SecondInterceptor();
    }

    @Bean
    public ThirdInterceptor thirdInterceptor() {

        return new ThirdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 拦截器一
        registry.addInterceptor(this.firstInterceptor()).addPathPatterns("/**");
        // 拦截器二
        registry.addInterceptor(this.secondInterceptor()).addPathPatterns("/users/testInterceptor02");
        // 拦截器三
        registry.addInterceptor(this.thirdInterceptor()).addPathPatterns("/**");    }
}
