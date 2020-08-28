package com.huazai.springcloud.alibaba.provider.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pyh
 * @date 2020/8/28 19:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPaymentMain9002.class, args);
    }
}
