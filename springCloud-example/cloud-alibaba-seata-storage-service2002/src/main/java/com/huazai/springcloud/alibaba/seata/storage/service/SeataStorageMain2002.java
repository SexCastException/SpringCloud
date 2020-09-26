package com.huazai.springcloud.alibaba.seata.storage.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author pyh
 * @date 2020/9/22 22:49
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication/*(exclude = DataSourceAutoConfiguration.class)*///取消数据源自动创建的配置
public class SeataStorageMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2002.class, args);
    }
}
