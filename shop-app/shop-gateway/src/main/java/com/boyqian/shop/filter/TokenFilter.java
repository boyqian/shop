package com.boyqian.shop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author boyqian
 * @time 2020/03/11 21:15
 * @Description  Token验证器 请求前传递的token
 * */
@Component
@Slf4j
public class TokenFilter extends AbstractPreZuulFilter{

    // order的值越小优先级越高
    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    protected Object cRun() {
        HttpServletRequest request=context.getRequest();
        log.info("Request Method {},Request URL{}", request.getMethod(), request.getRequestURL().toString());
       // 自己逻辑验证token的代码
        Object token=request.getParameter("token");
        if(null == token){
            log.error("token is empty");
            return fail(403,"未授权的token");
        }
        return success();// 过滤器继续往下走
    }
}
