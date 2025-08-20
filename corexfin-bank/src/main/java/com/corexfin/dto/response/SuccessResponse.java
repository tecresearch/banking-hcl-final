package com.corexfin.dto.response;

import java.sql.Timestamp;


public class SuccessResponse {

          protected String message;
          protected boolean status;
          protected int httpStatus;
          protected String path;
          protected Timestamp timestamp;
public SuccessResponse() {}
    public SuccessResponse(String message, boolean status, int httpStatus, String path, Timestamp timestamp) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SuccessResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", httpStatus=" + httpStatus +
                ", path='" + path + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
