package com.example.uad.common;

import com.example.uad.error.ApplicationException;
import com.example.uad.error.ApplicationError;
import com.example.uad.error.ValidationError;
import com.example.uad.error.ErrorDescription;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public ApplicationError handleApplicationException(ApplicationException ex, HttpServletResponse response) {
        response.setStatus(ex.getError().getHttpStatus().value());
        return ex.getError();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApplicationError handleValidationException(MethodArgumentNotValidException ex) {
        List<ValidationError> validationErrorList = new ArrayList<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(
                        it -> validationErrorList.add(
                                new ValidationError(
                                        Objects.requireNonNull(it.getDefaultMessage()), it.getField()
                                )
                        )
                );

        ApplicationError error = ErrorDescription.USER_DATA_NOT_VALID.createApplicationError();
        error.setData(validationErrorList);
        return error;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApplicationError handleMessageNotReadableException(HttpMessageNotReadableException ex){
        return ErrorDescription.USER_DATA_NOT_VALID.createApplicationError();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApplicationError handleCommonException(Exception ex){
        ApplicationError error = ErrorDescription.UNKNOWN_ERROR.createApplicationError();
        if (ex.getCause() != null) {
            error.setCause(ex.getCause().getMessage());
        }
        return error;
    }

}


