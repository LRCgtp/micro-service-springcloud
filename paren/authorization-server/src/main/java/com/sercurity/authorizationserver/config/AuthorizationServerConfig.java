package com.sercurity.authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author ruicai.li@hand-china.com
 */
@EnableAuthorizationServer //开启授权服务器
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final static String RESOURCE_ID="user";
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置一个客户端
        //客户端可通过授权码/用户名密码方式获取令牌
        clients.inMemory().withClient("client")
            .authorizedGrantTypes("Authorization_Code","password","refresh_token")
            .scopes("all")  // 允许请求范围
            .secret("secret") //客户端安全码
            .redirectUris("http://localhost:8888"); //回调地址
    }

    //配置Authorization TokenService
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
     endpoints.tokenStore(new InMemoryTokenStore())
         .accessTokenConverter(accessTokenConverter())
         .authenticationManager(authenticationManager)
         .reuseRefreshTokens(false);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许所有访问令牌
        //已经验证通过的客户端才能访问check_token断点
        security.tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()")
            .allowFormAuthenticationForClients();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("secret");
        return jwtAccessTokenConverter;
    }
}
