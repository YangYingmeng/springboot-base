package com.zhudao.springboot.mvc.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: FirstInterceptor
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 10:37
 */
@Slf4j
public class FirstInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("[preHandle][handler({})]", handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("[postHandle][handler({})]", handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info("[afterCompletion][handler({})]", handler, ex);
    }
}
