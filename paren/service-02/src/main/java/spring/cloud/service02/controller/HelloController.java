package spring.cloud.service02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruicai.li@hand-china.com
 */
@RestController
@RequestMapping
public class HelloController {

    @GetMapping("hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        StringBuffer requestURL = request.getRequestURL();
        return "hello service ====================>"+requestURL;
    }
}
