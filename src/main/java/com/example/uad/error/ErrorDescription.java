package com.example.uad.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Ошибки приложения.
 */
@Getter
@RequiredArgsConstructor
public enum ErrorDescription {

    UNAUTHORIZED_ACCESS("SYSTEM_401", "Неавторизованный доступ",CustomHttpStatus.UNAUTHORIZED),
    ACCESS_DENIED("SYSTEM_403", "Недостаточно прав для доступа к ресурсу", CustomHttpStatus.FORBIDDEN),
    HANDLER_NOT_FOUND("SYSTEM_404", "HANDLER_NOT_FOUND", CustomHttpStatus.NOT_FOUND),
    UNKNOWN_ERROR("SYSTEM_500", "Неизвестная ошибка сервера", CustomHttpStatus.INTERNAL_SERVER_ERROR),
    SERVICE_UNAVAILABLE("SYSTEM_503", "Сервис недоступен",CustomHttpStatus.SERVICE_UNAVAILABLE),
    USER_NOT_FOUND("USER_001", "Пользователь не найден", CustomHttpStatus.NOT_FOUND),
    USER_ALREADY_EXIST("USER_002", "Пользователь уже существует", CustomHttpStatus.CONFLICT),
    EMAIL_IS_NOT_CORRECT("USER_003", "Некорректный адрес электронной почты", CustomHttpStatus.BAD_REQUEST),
    EMAIL_BUSY("USER_005", "Адрес электронной почты занят", CustomHttpStatus.CONFLICT),
    PHONE_BUSY("USER_006", "Номер телефона занят", CustomHttpStatus.CONFLICT),
    PHONE_IS_NOT_CORRECT("USER_004", "Некорректный телефон", CustomHttpStatus.BAD_REQUEST),
    PHONE_IS_NOT_UPDATED("USER_007", "Данный номер телефона уже используется текущим пользователем", CustomHttpStatus.BAD_REQUEST),
    USER_DATA_NOT_VALID("USER__008", "Данные пользователя не валидны", CustomHttpStatus.BAD_REQUEST),
    UNKNOWN_USER_TYPE("USER__009", "Неизвестный тип пользователя", CustomHttpStatus.BAD_REQUEST),
    PASSWORD_IS_NOT_CORRECT("PASSWORD_001", "Некорректный пароль", CustomHttpStatus.BAD_REQUEST),
    PASSWORDS_NOT_EQUALS("PASSWORD_002", "Пароли не совпадают", CustomHttpStatus.BAD_REQUEST),
    INCORRECT_OLD_PASSWORD("PASSWORD_003", "Старый пароль введен неверно", CustomHttpStatus.BAD_REQUEST),
    CAPTCHA_SERVICE_ERROR("88", "Произошла техническая ошибка. Пожалуйста, попробуйте позже.", CustomHttpStatus.BAD_REQUEST),
    CAPTCHA_NOT_VALID("CAPTCHA_001", "Ошибка проверки капчи", CustomHttpStatus.INTERNAL_SERVER_ERROR),
    FORGOT_PASSWORD_NOT_FOUND("FORGOT_PASSWORD_002", "Запрос восстановления пароля с заданным" +
            " идентификатором не найден", CustomHttpStatus.NOT_FOUND),
    FORGOT_PASSWORD_WAS_USED("FORGOT_PASSWORD_003", "Не удалось подтвердить смену пароля." +
            " Пожалуйста, запросите ссылку на сброс пароля еще раз", CustomHttpStatus.BAD_REQUEST),
    FORGOT_PASSWORD_EXPIRED("FORGOT_PASSWORD_004", "Срок использования ссылки восстановления " +
            "пароля истек. Пожалуйста, запросите ссылку на сброс пароля еще раз", CustomHttpStatus.BAD_REQUEST),
    EMAIL_CONFIRMATION_NOT_REQUIRED("EMAIL_001", "Подтверждение e-mail не требуется, так как" +
            " он уже подтвержден", CustomHttpStatus.CONFLICT),
    EMAIL_CONFIRMATION_CODE_EXPIRED("EMAIL_002", "Срок годности кода подтверждения истек", CustomHttpStatus.BAD_REQUEST),
    NO_EMAIL_CONFIRMATION_FOUND("EMAIL_003", "Код введен неверно или истекло время ожидания", CustomHttpStatus.NOT_FOUND),
    EMAIL_NOT_WIRED("EMAIL_004", "Данный e-mail не привязан к личному кабинету", CustomHttpStatus.BAD_REQUEST),
    EMAIL_CONFIRMATION_INCORRECT_CODE_TYPE("EMAIL_005", "Некорректный тип кода подтверждения e-mail", CustomHttpStatus.BAD_REQUEST),
    EMAIL_IS_NOT_UPDATED("EMAIL__006", "Данная почта уже используется текущим пользователем", CustomHttpStatus.BAD_REQUEST),
    EMAIL_CONFIRMATION_SEND_ERROR("EMAIL__007", "Не удалось отправить код подтверждения на почту", CustomHttpStatus.BAD_REQUEST),
    SMS_CONFIRMATION_NOT_REQUIRED("SMS_001", "Подтверждение номера телефона не требуется, " +
            "так как он уже подтвержден", CustomHttpStatus.CONFLICT),
    SMS_CONFIRMATION_CODE_EXPIRED("SMS_002", "Срок годности кода подтверждения истек", CustomHttpStatus.BAD_REQUEST),
    NO_SMS_CONFIRMATION_FOUND("SMS_003", "Код введен неверно или истекло время ожидания", CustomHttpStatus.NOT_FOUND),
    PHONE_NOT_WIRED("SMS_004", "Данный номер телефона не привязан к личному кабинету", CustomHttpStatus.BAD_REQUEST),
    SMS_CONFIRMATION_INCORRECT_CODE_TYPE("SMS_005", "Некорректный тип кода подтверждения " +
            "номера мобильного телефона", CustomHttpStatus.BAD_REQUEST),
    SMS_CONFIRMATION_SEND_ERROR("SMS_006", "Некорректный тип кода подтверждения " +
            "номера мобильного телефона", CustomHttpStatus.BAD_REQUEST),
    ACCESS_TOKEN_NOT_FOUND("SECURITY_001", "Токен доступа с заданным идентификатором не найден", CustomHttpStatus.NOT_FOUND),
    AUTH_TOKEN_IS_NULL("SECURITY_002", "Токен доступа отсутствует", CustomHttpStatus.NOT_FOUND),
    REFRESH_EXPIRED_TOKEN_ERROR("SECURITY_004", "Невозможно обновить аутентификационный токен " +
            "- истек срок обновления токена", CustomHttpStatus.BAD_REQUEST),
    WRONG_LOGIN_OR_PASSWORD("SECURITY_005", "Неверный логин или пароль", CustomHttpStatus.BAD_REQUEST),
    AUTHORIZATION_LIMIT_EXCEEDED("SECURITY_006", "Превышено максимальное количество попыток авторизации", CustomHttpStatus.CONFLICT),
    VERSION_UNSUPPORTED("469", "Версия не поддерживается", CustomHttpStatus.BAD_REQUEST),
    ASU_PTP_ERROR("ASU_PTP_01", "Ошибка при интеграции с АСУ ПТП", CustomHttpStatus.INTERNAL_SERVER_ERROR),
    NOTIFICATION_UNKNOWN("NOT_03", "Неизвестная ошибка при работе с нотификациями", CustomHttpStatus.INTERNAL_SERVER_ERROR),
    NOTIFICATION_FORBIDDEN("NOT_02", "Доступ к нотификации запрещен", CustomHttpStatus.FORBIDDEN),
    NOTIFICATION_NOT_FOUND("NOT_01", "Нотификация не найдена", CustomHttpStatus.NOT_FOUND),
    APPEAL_NOT_FOUND("USER_001", "Пользователь не найден", CustomHttpStatus.BAD_REQUEST),
    PAYMENT_SYSTEM_ERROR("PAYMENT_001", "Ошибка проведения платежа", CustomHttpStatus.INTERNAL_SERVER_ERROR),
    PAYMENT_NOT_FOUND("PAYMENT_002", "Платёж не найден", CustomHttpStatus.BAD_REQUEST),
    PAYMENT_SUM_INCORRECT("PAYMENT_003", "Сумма платежа должна быть не больше, чем остаток к оплате.", CustomHttpStatus.BAD_REQUEST),
    OFD_INFO_NOT_FOUND("OFD_INFO_001", "Информация о фискальном чеке не найдена", CustomHttpStatus.BAD_REQUEST),
    INN_VALIDATION_DISABLED("INN__01", "Валидация ИНН отключена", CustomHttpStatus.SERVICE_UNAVAILABLE),

    FAILED_TO_CREATE_TECH_FEEDBACK("FEEDBACK__001", "Произошла ошибка при создании обращения в техподдержку", CustomHttpStatus.INTERNAL_SERVER_ERROR),
    INCORRECT_TECH_FEEDBACK_REQUEST("FEEDBACK__002", "Неверные данные для создания обращения в техподдержку", CustomHttpStatus.BAD_REQUEST),
    INCORRECT_TECH_FEEDBACK_PROBLEM_TYPE("FEEDBACK__003", "Неизвестный тип проблемы", CustomHttpStatus.BAD_REQUEST),
    UNKNOWN_EMAIL_NOTIFICATION_TEMPLATE("ENT_01","Неизвестный тип шаблона",CustomHttpStatus.BAD_REQUEST),
    EMAIL_SEND_ERROR("EMAIL__008", "Не удалось отправить письмо на почту", CustomHttpStatus.INTERNAL_SERVER_ERROR),
    FAILED_TO_ATTACH_FILE("EMAIL__009", "Не удалось прикрепить файл к письму", CustomHttpStatus.INTERNAL_SERVER_ERROR);

    /**
     * Код ошибки приложения.
     */
    private final String code;

    /**
     * Сообщение ошибки приложения.
     */
    private final String message;

    /**
     * Код ошибки.
     */
    private final CustomHttpStatus httpStatus;

    /**
     * Получение кода ошибки.
     *
     * @return код ошибки.
     */
    public String getCode() {
        return code;
    }

    /**
     * Получение сообщения об ошибке.
     *
     * @return сообщение об ошибке.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Метод, выбрасывающий ошибку приложения.
     *
     * @throws ApplicationException ошибка, которую выбрасывает метод.
     */
    public void throwException() throws ApplicationException {
        throw exception();
    }

    /**
     * Метод, выбрасывающий ошибку, если объект == null.
     *
     * @param obj объект для проверки на null.
     */
    public void throwIfNull(Object obj) {
        if (obj == null) {
            throwException();
        }
    }

    /**
     * Метод, выбрасывающий ошибку, если условие истинно.
     *
     * @param condition условие для проверки.
     */
    public void throwIfTrue(Boolean condition) {
        if (condition) {
            throwException();
        }
    }

    /**
     * Метод, выбрасывающий ошибку, если условие ложно.
     *
     * @param condition условие для проверки.
     */
    public void throwIfFalse(Boolean condition) {
        if (!condition) {
            throwException();
        }
    }

    public ApplicationError createApplicationError() {
        return new ApplicationError(this.code, this.message, "", this.httpStatus);
    }

    public ApplicationException exception() {
        return new ApplicationException(createApplicationError());
    }

    public ApplicationException exception(Throwable throwable) {
        return new ApplicationException(createApplicationError(), throwable);
    }

}
