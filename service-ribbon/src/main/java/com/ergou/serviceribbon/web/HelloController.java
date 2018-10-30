package com.ergou.serviceribbon.web;

import com.ergou.serviceribbon.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午11:06 2018/10/16
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;


    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    //1,一个服务注册中心，eureka server,端口为8080
    //2,eureka-client工程跑了两个实例，端口分别为8081,8082，分别向服务注册中心注册
    //3,sercvice-ribbon端口为8083,向服务注册中心注册
    /*4,当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，
    因为用ribbon进行了负载均衡，会轮流的调用eureka-client：8081和8083 两个端口的client接口*/

}
