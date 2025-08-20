package com.corexfin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/register")
    public String login() {
        return "register success";
    }
   @GetMapping("/greeting")
   public String greet() {
       return "good evening";
   }

   @GetMapping("/info")
public ResponseEntity<?>getInfo(){
        return ResponseEntity.status(HttpStatus.OK).body("api-gateway and database configuration");
   }



}
