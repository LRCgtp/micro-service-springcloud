package spring.cloud.service01

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
object Service01Application {

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(Service01Application::class.java, *args)
    }

}
