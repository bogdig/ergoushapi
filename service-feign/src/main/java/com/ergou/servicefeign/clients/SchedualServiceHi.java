package com.ergou.servicefeign.clients;

import com.ergou.servicefeign.clients.impl.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午11:42 2018/10/16
 */

//定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务。比如在代码中调用了service-hi服务的“/hi”接口

@FeignClient(value = "eureka-client", fallback = SchedualServiceHiHystric.class)
//添加fallback，熔断类为SchedualServiceHiHystric
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
