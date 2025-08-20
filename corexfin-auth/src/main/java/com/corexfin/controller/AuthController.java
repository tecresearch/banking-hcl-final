package com.corexfin.controller;

import com.corexfin.dto.request.LoginRequest;
import com.corexfin.dto.response.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/api/v1")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> loginByUserNameAndPassword(@RequestBody LoginRequest loginRequest, WebRequest webRequest) {
       LoginResponse response=new LoginResponse();
       response.setId("2324");
       response.setToken("2333333333333");
       response.setMessage("success");
       response.setPath(webRequest.getDescription(false).replace("uri=",""));
       response.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
       response.setHttpStatus(HttpStatus.ACCEPTED.value());
       Map<String,Object> map=new HashMap<>();
       map.put("request",loginRequest);
       map.put("response",response);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
    }

}
