package com.zhudao.springboot.mvc.core.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: TestServletContextListener
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 11:09
 */
@Slf4j
@WebListener
public class TestServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("[contextInitialized]");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
