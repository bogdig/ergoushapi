package com.ergou.servicezipkinmiya;

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
public class ServiceZipkinmiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinmiyaApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceZipkinmiyaApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String home() {
        LOG.log(Level.INFO, "hi is being called");
        return "hi i am miya";
    }

    @RequestMapping("/miyainfo")
    public String miyainfo() {
        LOG.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://localhost:8086/hiinfo", String.class);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
