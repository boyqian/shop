package com.boyqian.shop.filter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author boyqian
 * @time 2020/03/11 21:25
 * @Description  使用Guuva的令牌桶算法实现限流的过滤器
 * */
@Slf4j
@Component
@SuppressWarnings("all") // 忽略代码中的警告信息
public class RateLimiterFilter extends  AbstractPreZuulFilter{

    // 创建一个每秒可以获取200个令牌(请求)的限流器
    RateLimiter rateLimiter=RateLimiter.create(200.0);

    @Override
    protected Object cRun() {
        HttpServletRequest request=context.getRequest();
        if(rateLimiter.tryAcquire()){
            log.info("get rate token success");
            return success();
        }else{
            return fail(402,"当前请求人数过多，请求稍后再试");
        }
    }

    // 只有通过token的才去限流 ，可自定义先后顺序
    @Override
    public int filterOrder() {
        return 2;
    }
}
