package spring.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruicai.li@hand-china.com
 */
@RefreshScope
@RestController
@RequestMapping
public class HelloController {

    @Value("${version}")
    private String version;

    @GetMapping("version")
    public String getValu(){
        return version;
    }
}
