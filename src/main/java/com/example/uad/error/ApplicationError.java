package com.example.uad.error;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApplicationError {

    private String code;
    private String message;
    private String cause;
    private List<ValidationError> data;
    private HttpStatus httpStatus;

    public ApplicationError() {
    }

    public ApplicationError(String code, String message, String cause) {
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    public ApplicationError(String code, String message, String cause, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.cause = cause;
        this.httpStatus = httpStatus;
    }

    public ApplicationError(String code, String message, String cause, List<ValidationError> data, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.cause = cause;
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setData(List<ValidationError> validationErrors){
        this.data = validationErrors;
    }

    public String getCode() {
        return code;
    }

    public String getCause() {
        return cause;
    }

    public List<ValidationError> getData() {
        return data;
    }

    public ApplicationError setCause(String cause) {
        this.cause = cause;
        return this;
    }
}