package com.huazai.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pyh
 * @date 2020/7/20 22:08
 */
@Configuration
public class IRuleConfiguration {
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
