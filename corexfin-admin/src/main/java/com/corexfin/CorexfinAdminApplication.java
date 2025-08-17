package com.corexfin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CorexfinAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorexfinAdminApplication.class, args);
    }

}
