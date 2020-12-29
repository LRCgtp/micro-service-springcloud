package com.getway.springcloudgetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGetwayApplication.class, args);
    }

}
