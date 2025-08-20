package com.corexfin.controller;
import com.corexfin.shared.model.Bank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test/login")
    public ResponseEntity<Bank> login() {
        Bank hex=new Bank();
        hex.setName("hex Of Bank India");
        hex.setEmail("hXB@hexbank.com");
        hex.setDomain("https://www.hexbank.com");
        hex.setOwner("Shrisht dev");
        hex.setRole("admin");
        hex.setOffice("Greater Noida");
        hex.setUsername("mr_dev");
        hex.setPassword("hex@admin");
        hex.setStatus("Pending");
        hex.setOffice("Greater Noida");
        return ResponseEntity.ok(hex);
    }
}
