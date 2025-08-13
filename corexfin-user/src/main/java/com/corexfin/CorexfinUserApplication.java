package com.corexfin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CorexfinUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorexfinUserApplication.class, args);
    }

}
