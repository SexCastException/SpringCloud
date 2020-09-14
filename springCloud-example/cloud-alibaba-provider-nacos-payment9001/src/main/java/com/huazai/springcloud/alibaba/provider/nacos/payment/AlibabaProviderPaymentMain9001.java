package com.huazai.springcloud.alibaba.provider.nacos.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pyh
 * @date 2020/8/27 22:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPaymentMain9001.class, args);
    }
}
