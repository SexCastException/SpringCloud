package com.huazai.springcloud.alibaba.seata.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author pyh
 * @date 2020/9/22 22:49
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2002.class, args);
    }
}
