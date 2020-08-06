package com.huazai.springcloud.feign.hystrix.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author pyh
 * @date 2020/7/27 22:14
 */

@SpringBootApplication
@EnableFeignClients
public class PaymentFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentFeignHystrixMain80.class, args);
    }
}
