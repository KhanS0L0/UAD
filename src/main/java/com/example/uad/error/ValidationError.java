package com.example.uad.error;

public class ValidationError {

    private String message;

    private String field;

    public ValidationError() {
    }

    public ValidationError(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "message='" + message + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
