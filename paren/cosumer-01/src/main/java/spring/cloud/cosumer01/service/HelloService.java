package spring.cloud.cosumer01.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ruicai.li@hand-china.com
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFalback")
    public String hello(){
        try {
            ResponseEntity<String> forEntity = restTemplate.getForEntity("http://service-provider/hello", String.class, "");
            return forEntity.getBody();
        }catch (Exception e){
            throw new RuntimeException("我抛出异常了"+e.getMessage());
        }
    }

    public String helloFalback(Throwable e){
        System.out.println("服务异常信息================>"+e.getMessage());
        return "服务端异常导致调用异常！！！！！！！！！！";
    }
}
