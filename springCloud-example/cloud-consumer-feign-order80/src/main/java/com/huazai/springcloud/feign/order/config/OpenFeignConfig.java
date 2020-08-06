package com.huazai.springcloud.feign.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pyh
 * @date 2020/7/24 0:07
 */
@Configuration
public class OpenFeignConfig {
    /**
     * 开启openfeign日志功能
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
