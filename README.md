# micro-service-springcloud
微服务架构探索

项目是关于SpringCloud微服务治理框架的基础组件学习，共包括了一下几个组件
1.微服务网关
2.注册中心
3.微服务调用组件
4.微服务配置中心等组件

组件介绍

一：微服务网关SpringCloud gateway
网关处理步骤：
客户端请求--->网关映射器----->网关web处理器------>网关代理服务------->调用对应的微服务处理请求
a.网关映射器：
spring:
  application:
    name: api-getway
  cloud:
    gateway:
      routes:
      - id: user_route
        uri: http://localhost:7071 #面向地址调用服务
        #uri: lb://cosumer-01 # 面向服务调用 lb: 使用负载均衡策略   userservices代表注册中心的具体服务名
        predicates:
        - Path=/cosumer/**
根据ip请求匹配到对应的断言，然后请求到uri对应的微服务
b.网关web处理器：
web处理器主要定义了两种类型的过滤器全局过滤器/局部过滤器(针对具体的某个服务)
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_header_route
        uri: https://example.org
        predicates:
        - Path=/cosumer/**
        filters:
        - AddRequestHeader=X-Request-red, blue


~~~~后续会更新Dubble阿里系的微服务治理框架的相关学习内容
