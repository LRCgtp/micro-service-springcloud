package spring.cloud.commonfeigin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.commonfeigin.feigin.FeiginService;

/**
 * @author ruicai.li@hand-china.com
 */
@RestController
@RequestMapping
public class FeiginController {

    @Autowired
    private FeiginService feiginService;

    @GetMapping("get")
    public String get(HttpServletRequest request, HttpServletResponse response){
        String result = feiginService.hello(request, response);
        return result;
    }
}
