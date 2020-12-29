package spriing.cloud.eureka01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka01Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka01Application.class, args);
    }

}
