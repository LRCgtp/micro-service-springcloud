package com.security.resouceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ResouceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResouceServerApplication.class, args);
    }

}
