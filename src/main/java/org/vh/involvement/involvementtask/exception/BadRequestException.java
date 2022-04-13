package org.vh.involvement.involvementtask.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends AppException {

    public BadRequestException(String message, String errorCode, String field) {
        super(message, errorCode, field);
    }

    BadRequestException(String message, String errorCode) {
        super(message, errorCode);
    }

}
