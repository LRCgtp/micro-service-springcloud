package com.security.resouceserver.controller;

import com.security.resouceserver.domain.Instance;
import com.security.resouceserver.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruicai.li@hand-china.com
 */
@RestController
@RequestMapping
public class ResourceController {
    private final static Logger logger = LoggerFactory.getLogger(ResourceController.class);
    private final static String DEFAULT_NAME = "李锐才";
    private static String DEFAULT_SERVICE_ID = "appl cation";
    private static String DEFAULT_HOST = "localhost";
    private static int DEFAULT_PORT = 8080;

    //受保护的资源
    @GetMapping(value = "/user/{userid}")
    public User getUserByUserid(@PathVariable("userid ") String userid) {
        logger.info("Get User by Userid {}", userid);
        return new User(Long.valueOf(userid), DEFAULT_NAME, null);
    }

    //不受保护的资源
    @GetMapping("/instace/{serviceId}")
    public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
        logger.info("Get Instance By serviceId {}" + serviceId);
        return new Instance(serviceId, DEFAULT_HOST, DEFAULT_PORT);
    }
}