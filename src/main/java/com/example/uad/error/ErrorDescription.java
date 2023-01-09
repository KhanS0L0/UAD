package com.example.uad.error;

import org.springframework.http.HttpStatus;

/**
 * Ошибки приложения.
 */
public enum ErrorDescription {

    HANDLER_NOT_FOUND("SYSTEM_500", "Данный метод не поддерживается", HttpStatus.BAD_REQUEST),
    UNKNOWN_ERROR("SYSTEM_500", "Неизвестная ошибка сервера", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_DATA_NOT_VALID("USER__001", "Данные пользователя не валидны", HttpStatus.BAD_REQUEST),
    CONTRACT_NOT_FOUND("CONTRACT__001", "Не удалось найти контакт", HttpStatus.BAD_REQUEST),
    ATTRIBUTE_NOT_FOUND("ATTRIBUTE__001", "Не удалось найти аттрибут контакта", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorDescription(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ApplicationError createApplicationError(){
        return new ApplicationError(this.code, this.message, "", this.httpStatus);
    }

    public ApplicationException exception() {
        return new ApplicationException(createApplicationError());
    }

}
