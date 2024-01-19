package com.nico.springbootprueba.entity;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private String timestamp;
    private int status;
    private HttpStatus error;
    private String message;

    public ErrorMessage() {

    }

    public ErrorMessage(String timestamp, int status, HttpStatus error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", error=" + error +
                ", message='" + message + '\'' +
                '}';
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HttpStatus getError() {
        return error;
    }

    public void setError(HttpStatus error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
