package com.huazai.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该包需要放在springboot包扫描之外
 *
 * @author pyh
 * @date 2020/7/20 22:08
 */
@Configuration
public class IRuleConfiguration {
    /**
     * 配置负载均衡规则
     *
     * @return
     */
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
