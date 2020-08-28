package com.huazai.springcloud.alibaba.consumer.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pyh
 * @date 2020/8/28 20:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConsumerOrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerOrderMain83.class, args);
    }
}
