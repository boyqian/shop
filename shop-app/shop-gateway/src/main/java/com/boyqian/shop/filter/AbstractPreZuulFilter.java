package com.boyqian.shop.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author boyqian
 * @time 2020/03/11 21:12
 * @Description  网关过滤器执行前的代码
 * */
public abstract class AbstractPreZuulFilter extends AbstractZuulFilter{

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
}
