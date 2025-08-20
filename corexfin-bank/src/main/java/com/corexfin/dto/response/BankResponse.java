package com.corexfin.dto.response;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BankResponse extends SuccessResponse {
    private String id;

    public BankResponse() {}

    public BankResponse(String id) {
        this.id = id;
    }

    public BankResponse(String message, boolean status, int httpStatus, String path, Timestamp timestamp, String id) {
        super(message, status, httpStatus, path, timestamp);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BankResponse{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", httpStatus=" + httpStatus +
                ", path='" + path + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
