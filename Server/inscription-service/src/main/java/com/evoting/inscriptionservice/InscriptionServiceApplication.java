package com.evoting.inscriptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class InscriptionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InscriptionServiceApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String home() {
        return "Service Inscription...";
    }

}
