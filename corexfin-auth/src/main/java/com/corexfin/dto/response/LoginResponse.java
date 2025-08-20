package com.corexfin.dto.response;

import java.sql.Timestamp;

public class LoginResponse extends SuccessResponse {
    private String id;
    private String token;
    public LoginResponse(){}

    public LoginResponse(String id) {
        this.id = id;
    }

    public LoginResponse(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public LoginResponse(String message, boolean status, int httpStatus, String path, Timestamp timestamp, String id, String token) {
        super(message, status, httpStatus, path, timestamp);
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
