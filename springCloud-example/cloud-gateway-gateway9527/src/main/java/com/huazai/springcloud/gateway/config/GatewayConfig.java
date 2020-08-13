package com.huazai.springcloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pyh
 * @date 2020/8/13 21:58
 */
@Configuration
public class GatewayConfig {
    /**
     * javaconfig方法配置路由
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("route_payment3", r -> r.path("/guonei").uri("http://news.baidu.com")).build();
        return routes.build();

    }
}
