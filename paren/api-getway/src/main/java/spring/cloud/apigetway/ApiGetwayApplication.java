package spring.cloud.apigetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import spring.cloud.apigetway.filter.ApiFilter;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGetwayApplication.class, args);
    }

    @Bean
    public ApiFilter apiFilter(){
        return new ApiFilter();
    }
}
