package com.ergou.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                //basic proxy
                .route(r -> r.path("/baidu")
                        .uri("http://baidu.com:80/")
                ).build();
    }

//    @RequestMapping("/fallback")
//    public Mono<String> fallBack() {
//        return Mono.just("fallback");
//    }


}
