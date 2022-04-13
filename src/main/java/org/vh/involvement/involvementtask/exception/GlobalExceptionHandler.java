package org.vh.involvement.involvementtask.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public AppExceptionResponse handleAppException(AppException exception) {
        log.error(exception.getMessage(), exception);
        return new AppExceptionResponse(exception.getMessage(), exception.getErrorCode());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppExceptionResponse handleBadRequestException(BadRequestException exception) {
        return new AppExceptionResponse(exception.getMessage(), exception.getErrorCode(), exception.getField());
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppExceptionResponse handleRecordNotFoundException(RecordNotFoundException exception) {
        return new AppExceptionResponse(exception.getMessage(), exception.getErrorCode());
    }


}
