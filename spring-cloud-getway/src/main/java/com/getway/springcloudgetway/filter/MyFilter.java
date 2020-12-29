package com.getway.springcloudgetway.filter;

import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ruicai.li@hand-china.com
 */
//@Component
public class MyFilter implements GlobalFilter, Order {
    static Logger logger= LoggerFactory.getLogger(MyFilter.class);
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("进入过滤器---------------------------");
        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        RequestPath path = request.getPath();
        System.out.println("获取到的路径----------------"+uri);
        System.out.println("获取请求路径----------------"+path);
        HttpHeaders headers = request.getHeaders();
        List<String> stringList = headers.get("Authorization");
        logger.info("获取到的请求头中的令牌认证信息--------------------"+stringList.get(0));
        ServerHttpResponse response = exchange.getResponse();
        //headers.add("USER_NAME","我通過了過濾器!");
        response.setStatusCode(HttpStatus.OK);
        return chain.filter(exchange);
    }

    @Override
    public int value() {
        return 0;
    }
}
