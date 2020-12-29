package com.sercurity.authorizationserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author ruicai.li@hand-china.com
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中创建两个用户
        InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("user_authorization_code").
            password("123456").authorities("USER").build());
        userDetailsManager.createUser(User.withUsername("password").
            password("123456").authorities("USER").build());
        auth.userDetailsService(userDetailsManager);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager authenticationManager = super.authenticationManagerBean();
        return authenticationManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许访问/oauth授权接口
        http.csrf().disable()
           .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .requestMatchers().anyRequest()
            .and()
            .formLogin().permitAll()
            .and()
            .authorizeRequests()
            .antMatchers("/oauth/**").permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
        return passwordEncoder;
    }
}
