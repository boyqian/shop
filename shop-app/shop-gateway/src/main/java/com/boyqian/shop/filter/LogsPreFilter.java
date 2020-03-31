package com.boyqian.shop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author boyqian
 * @time 2020/03/11 21:32
 * @Description  日志过滤器，获取用户的访问日志，包括用户请求的延迟，路径，返回的内容等等等
 * */
@Slf4j
@Component
public class LogsPreFilter extends AbstractPreZuulFilter{

    @Override
    protected Object cRun() {
        // 存储客户端请求的时间戳
        context.set("startTime",System.currentTimeMillis());
        return success();
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
