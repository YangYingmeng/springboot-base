package com.zhudao.springboot.mvc.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: TestServlet
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 11:08
 */
@Slf4j
@WebServlet(urlPatterns = "/test/servlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[doGet][uri: {}]", req.getRequestURI());
    }
}
