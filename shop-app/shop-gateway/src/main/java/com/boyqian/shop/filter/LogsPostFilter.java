package com.boyqian.shop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author boyqian
 * @time 2020/03/11 21:35
 * @Description  日志过滤器
 * */
@Component
@Slf4j
public class LogsPostFilter extends  AbstractPostZuulFilter {

    @Override
    protected Object cRun() {
        HttpServletRequest request = context.getRequest();
        long startTime = (Long) context.get("startTime");
        String uri = request.getRequestURI();
        long endTime = System.currentTimeMillis();
        log.info("URI: {}, Time:{}", uri, endTime-startTime);
        return success();
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }
}
