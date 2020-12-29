package spring.cloud.service01.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruicai.li@hand-china.com
 */
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private Environment env;

    @GetMapping("hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        StringBuffer requestURL = request.getRequestURL();
        return "hello service ====================>"+requestURL;
    }

    @GetMapping("get")
    public void get(){
        String property = env.getProperty("spring.application.name");
        System.out.println("属性===========================>:"+property);
    }
}
