package com.ergou.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午10:59 2018/10/16
 */

@Service
public class HelloService {

    @Autowired//通过之前注入ioc容器的restTemplate来消费eureka-client服务的“/hi”接口
    RestTemplate restTemplate;



    /*在这里我们直接用的程序名替代了具体的url地址，
    在ribbon中它会根据服务名来选择具体的服务实例，
    根据服务实例在请求的时候会用具体的url替换掉服务名*/


    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-client/hi?name = " + name, String.class);
    }

    public String hiError(String name) {
        return "sorry " + name + " you failure";
    }

}
