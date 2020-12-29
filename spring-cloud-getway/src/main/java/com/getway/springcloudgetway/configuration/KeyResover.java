package com.getway.springcloudgetway.configuration;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ruicai.li@hand-china.com
 */
@Configuration
public class KeyResover {

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(
            exchange.getRequest()
                .getRemoteAddress()
                .getHostName()
        );
    }
}
