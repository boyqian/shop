package com.boyqian.shop.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author boyqian
 * @time 2020/03/11 21:14
 * @Description  网关过滤器执行前的代码
 * */
public abstract class AbstractPostZuulFilter extends  AbstractZuulFilter{

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }
}
