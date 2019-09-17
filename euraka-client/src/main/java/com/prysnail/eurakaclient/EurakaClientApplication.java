package com.prysnail.eurakaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurakaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakaClientApplication.class, args);
    }

}
