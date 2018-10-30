package com.ergou.servicezipkinhi;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ServiceZipkinhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinhiApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceZipkinhiApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
        LOG.log(Level.INFO, "calling trace service-zipkinhi");
        return restTemplate.getForObject("http://localhost:8087/miyainfo", String.class);
    }

    @RequestMapping("/hiinfo")
    public String hiinfo() {
        LOG.log(Level.INFO, "calling trace service-zipkinhi");
        return "i am service-zipkinhi";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}



