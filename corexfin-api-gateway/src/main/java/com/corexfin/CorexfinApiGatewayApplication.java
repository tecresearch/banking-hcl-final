package com.corexfin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class TestController{
    @GetMapping("test")
    public String test(){
        return "Api Gateway Test: Success";
    }
}
@SpringBootApplication
@EnableDiscoveryClient
public class CorexfinApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorexfinApiGatewayApplication.class, args);
    }

}
