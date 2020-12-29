package com.getway.springcloudgetway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @author ruicai.li@hand-china.com
 */
@Component
public class LoginFilterGatewayFilterFactory extends AbstractGatewayFilterFactory {

    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }
}
