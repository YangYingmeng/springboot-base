package com.zhudao.springboot.mvc.core.web;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.zhudao.springboot.mvc.core.vo.CommonResult;

/**
 * 拦截controller所在的包, 做统一的结果返回
 * SpringMVC可以通过ResponseBodyAdvice + @ControllerAdvice拦截controller的返回结果
 *
 * @Description: GlobalResponseBodyHandler
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 10:02
 */
@ControllerAdvice(basePackages = "com.zhudao.springboot.mvc.controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        // true 表示拦截Controller所有的API返回的结果
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        // 建议团队做约定, 返回的结果必须加上CommonResult, 而不是统一修改返回结果
        // 如果已经是 CommonResult 类型，则直接返回
        if (body instanceof CommonResult) {
            return body;
        }
        // 如果不是，则包装成 CommonResult 类型
        return CommonResult.success(body);
    }
}
