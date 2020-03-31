package com.boyqian.shop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author boyqian
 * @time 2020/03/12 08:58
 * @Description 忽略统一响应注解定义,使用在类或者方法上面,实现响应拦截
 * */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
