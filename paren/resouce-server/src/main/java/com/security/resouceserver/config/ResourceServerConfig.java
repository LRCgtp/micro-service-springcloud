package com.security.resouceserver.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * @author ruicai.li@hand-china.com
 */
@EnableResourceServer //开启资源服务器
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
      resources.tokenStore(new JwtTokenStore(jwtAccessTokenConverter()))
          .stateless(true);
      //配置RemoteTokenService 用于认证AuthorizationServer上的令牌
        RemoteTokenServices tokenServices=new RemoteTokenServices();
        tokenServices.setAccessTokenConverter(jwtAccessTokenConverter());
        RestTemplate restTemplate = restTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response . getRawStatusCode ()  !=400){
                    super.handleError(response);
                }
            }
        });
        tokenServices.setRestTemplate(restTemplate);
        tokenServices.setCheckTokenEndpointUrl("htttp://authorization-server/oauth/check_token");
        tokenServices.setClientId("client");
        tokenServices.setClientSecret("secret");
        resources.tokenServices(tokenServices)
            .stateless(true);
    }

    //配置jwt转换器
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter=new JwtAccessTokenConverter();
        converter.setSigningKey("secret");
        return converter;
    }

    //配置ribbon负载均衡
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .requestMatchers().anyRequest()
            .and()
            .anonymous()
            .and()
            .authorizeRequests()
            .antMatchers("/user/**").authenticated()  //user端点 /user/**必须认证
        .and()
            .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
