package spring.cloud.commonfeigin.feigin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ruicai.li@hand-china.com
 */
@Component
@FeignClient(value = "service-provider")
public interface FeiginService {

    @GetMapping("hello")
    public String hello(@RequestParam(value = "request") HttpServletRequest request, @RequestParam(value = "response") HttpServletResponse response);
}
