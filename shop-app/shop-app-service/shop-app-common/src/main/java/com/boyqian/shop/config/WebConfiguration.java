package com.boyqian.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author boyqian
 * @time 2020/03/12 08:40
 * @Description  通用配置,定制HTTP消息转换器
 * */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    // 配置HTTP消息的转换器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        /**
         * 将JAVA的实体对象转换为数据的输出流 ，JSON的字符串数据格式
         */
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
