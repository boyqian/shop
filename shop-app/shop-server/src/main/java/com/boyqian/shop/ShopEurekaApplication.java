package com.boyqian.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author boyqian
 * @time 2020/03/11 10:29
 * @Description  创建服务注册中心启动入口
 * */
@EnableEurekaServer
@SpringBootApplication
public class ShopEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopEurekaApplication.class,args);
    }
}
