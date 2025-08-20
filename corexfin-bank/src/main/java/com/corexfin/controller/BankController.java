package com.corexfin.controller;

import com.corexfin.dto.request.BankRequest;
import com.corexfin.dto.response.BankResponse;
import com.corexfin.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * URI Versioning : Standard
 * /admin/ModelName/Version:v1/your-endpoint-crud
 */
@RestController
@RequestMapping("/admin/bank/v1")
public class BankController {
    private final BankService bankService;
    @Autowired
    public BankController(BankService bankService) {

        this.bankService = bankService;
    }


    @GetMapping("/test")
    public ResponseEntity<Map<String,Object>> test() {

        Map<String,Object> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "OK");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    /**
     * CRUD Rest EndPoints
     *  /**
     *             * BankRequest
     *             *  String name,
     *             *  String Domain,
     *             *  String username,
     *             *  String password,
     *             *  String owner,
     *             *  String email,
     *             *  String office,
     *             *  String status,
     *             *  String role
     *             */

    @PostMapping("/enroll")
    public ResponseEntity<BankResponse> enrollBank(@RequestBody  BankRequest bankRequest, WebRequest webRequest) {


            BankResponse response= bankService.addAdminBankInCorexfin(bankRequest, webRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
