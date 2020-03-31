package com.boyqian.shop.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author boyqian
 * @time 2020/03/11 14:50
 * @Description  自定义网关过滤器
 * */
public abstract class AbstractZuulFilter extends ZuulFilter {

    // 用于在过滤器之间传递消息，数据保存在每个请求的ThreadLocal中
    RequestContext context;

    // 是否继续执行过滤器
    private final static String NEXT="next";

    @Override
    public boolean shouldFilter() {
        RequestContext ctx=RequestContext.getCurrentContext();
        return (boolean)ctx.getOrDefault(NEXT,true);
    }

    @Override
    public Object run() throws ZuulException {
        context=RequestContext.getCurrentContext();
        return cRun();
    }
    protected  abstract  Object cRun();

    // 快速失败方法
    Object fail(int code,String msg){
        context.set(NEXT,false);
        context.setSendZuulResponse(false);
        context.getResponse().setContentType("text/html;charser=UTF-8");
        context.setResponseStatusCode(code);
        context.setResponseBody(String.format("{\"result\":\"%s!\"}", msg));
        return null;
    }

    // 成功的方法
    Object success(){
        context.set(NEXT,true);
        return null;
    }
}
