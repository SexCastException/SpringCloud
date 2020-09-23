package com.huazai.springcloud.alibaba.seata.order.service.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author pyh
 * @date 2020/9/22 22:57
 */
@Configuration
@MapperScan("com.huazai.springcloud.alibaba.seata.order.service.dao")
public class MybatisConfig {
}
