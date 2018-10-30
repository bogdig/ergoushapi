package com.ergou.servicefeign.web;

import com.ergou.servicefeign.clients.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午11:45 2018/10/16
 */

//在Web层的controller层，对外暴露一个"/hi"的API接口，通过上面定义的Feign客户端SchedualServiceHi 来消费服务

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi")
    public String sayHi(String name) {
        return schedualServiceHi.sayHiFromClientOne("feign"+name);
    }


}
