package com.boyqian.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author boyqian
 * @time 2020/03/11 14:23
 * @Description  网关应用程序启动入口
 * */
@EnableZuulProxy  // 标识为网关服务器
@SpringCloudApplication //组合注解 @SpringBootApplication  @EnableDiscoveryClient  @EnableCircuitBreaker(启动一个熔断器)
public class ZuulGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApplication.class,args);
    }
}
