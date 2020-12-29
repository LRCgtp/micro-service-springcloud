package spring.cloud.cosumer01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.cloud.cosumer01.service.HelloService;

/**
 * @author ruicai.li@hand-china.com
 */
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private HelloService helloService;

    @GetMapping("/cosumer")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        String res = request.getHeader("Authorization");
        String userName = request.getHeader("USER_NAME");
        System.out.println("收到網關傳遞過來的頭信息----------------"+res);
        System.out.println("獲取用戶名--------------"+userName);
        String resEntity = helloService.hello();
        String requestHeader = request.getHeader("X-Request-red");
        System.out.println("获取到请求头数据--------------"+requestHeader);
        return resEntity;
    }
}
