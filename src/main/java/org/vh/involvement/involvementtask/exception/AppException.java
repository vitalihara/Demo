package org.vh.involvement.involvementtask.exception;

import lombok.Getter;

@Getter
public class AppException extends Exception {
    private final String errorCode;
    private String field;

    AppException(String message, String errorCode, String field) {
        super(message);
        this.errorCode = errorCode;
        this.field = field;
    }

    AppException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
