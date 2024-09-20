package com.zhudao.springboot.mvc.core.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: TestFilter
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 11:05
 */
@Slf4j
@WebFilter("/test/*")
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("[doFilter]");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
