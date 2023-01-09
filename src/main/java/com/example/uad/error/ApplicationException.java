package com.example.uad.error;

public class ApplicationException extends RuntimeException{

    private ApplicationError error;
    private Throwable throwable;
    private String errorMessage;

    public ApplicationException() {
    }

    public ApplicationException(Throwable throwable, String errorMessage) {
        this.throwable = throwable;
        this.errorMessage = errorMessage;
    }

    public ApplicationException(ApplicationError error) {
        this.error = error;
        this.errorMessage = error.getMessage();
    }

    public ApplicationException(ApplicationError error, Throwable throwable) {
        this.error = error;
        this.throwable = throwable;
        this.errorMessage = error.getMessage();
    }

    public ApplicationError getError() {
        return error;
    }
}
