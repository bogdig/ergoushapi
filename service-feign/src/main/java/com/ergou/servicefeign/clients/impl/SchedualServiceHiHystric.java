package com.ergou.servicefeign.clients.impl;

import com.ergou.servicefeign.clients.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午7:26 2018/10/17
 */

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
