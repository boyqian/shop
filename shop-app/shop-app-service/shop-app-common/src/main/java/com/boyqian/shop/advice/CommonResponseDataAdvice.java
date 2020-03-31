package com.boyqian.shop.advice;

import com.boyqian.shop.annotation.IgnoreResponseAdvice;
import com.boyqian.shop.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author boyqian
 * @time 2020/03/12 09:01
 * @Description advice的后缀为增强功能，拦截所有的controller的数据返回
 * */
@RestControllerAdvice  // 组合注解 @ControllerAdvice  @ResponseBody
@SuppressWarnings("all")  // 忽略所有警告
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    // 判断是否需要对响应进行处理 true 需要 false 不需要
    // @Params methodParameter 方法的定义
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果当前方法所在的类标识了@IgnoreResponseAdvice的注解 则不需要处理
        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        // 如果当前方法所在的方法标识了@IgnoreResponseAdvice的注解 则不需要处理
        if(methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        // 对响应进行处理 执行beforeBodyWrite方法
        return true;
    }

    // @Params o Controller的返回对象，beforeBodyWrite在响应流之前进行处理
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 定义最终的返回对象
        CommonResponse<Object> response=new CommonResponse<>(0,"");
        if(null==o){
            return response;
        }else if(o instanceof CommonResponse){
            response=(CommonResponse<Object>) o;
        }else{
            response.setData(o);
        }
        return response;
    }
}
