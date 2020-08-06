package com.huazai.springcloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author pyh
 * @date 2020/7/16 21:16
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced   // 赋予RestTemplate负载均衡的能力，默认方式：轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
