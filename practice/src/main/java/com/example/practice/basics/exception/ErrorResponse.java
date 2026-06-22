package com.example.practice.basics.exception;
import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String error;
    public ErrorResponse(){}
    public ErrorResponse(
            LocalDateTime timestamp,
            int status,
            String message,
            String error
    ){
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
