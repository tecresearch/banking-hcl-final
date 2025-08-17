package com.corexfin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/admin")
    public ResponseEntity<Map<String,Object>> test() {
        Map<String,Object> map = new HashMap<>();
        map.put("status","running");
        map.put("message","admin service is running");
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
