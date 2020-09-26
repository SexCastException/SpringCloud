package com.huazai.springcloud.alibaba.seata.storage.service.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author pyh
 * @date 2020/9/23 21:00
 */
@Configuration
@MapperScan({"com.huazai.springcloud.alibaba.seata.order.service.dao"})
public class MyBatisConfig {
}
