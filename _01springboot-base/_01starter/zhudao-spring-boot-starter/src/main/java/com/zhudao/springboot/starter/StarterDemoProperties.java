package com.zhudao.springboot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: StarterDemo 配置类
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 10:05
 */
@ConfigurationProperties(prefix = "zhudao.demo")
public class StarterDemoProperties {

    private static final String DEFAULT_TEXT = "逐有道无术之道";

    private String text = DEFAULT_TEXT;

    public static String getDefaultText() {
        return DEFAULT_TEXT;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
