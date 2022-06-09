package com.syning.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    /**
     *  配置了一个 id 为 path_route_syning 的路由规则
     *  当访问地址 localhost:9527/guonei 时，将会自动转发到地址 http://news.baidu.com//guonei
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_syning",   // id
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com//guonei")).build();
                // 映射规则，访问localhost:9527 网关将会转发到 http://news.baidu.com//guonei


        routes.route("path_route_syning2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }

}
