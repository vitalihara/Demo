package org.vh.involvement.involvementtask.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<AppExceptionResponse> handleBadRequestException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private List<AppExceptionResponse> processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        List<AppExceptionResponse> errorsResponse = new ArrayList<>();
        for (org.springframework.validation.FieldError fieldError : fieldErrors) {
            errorsResponse.add(new AppExceptionResponse(fieldError.getDefaultMessage(), fieldError.getCode(), fieldError.getField()));
        }
        return errorsResponse;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppExceptionResponse handleRecordNotFoundException(RecordNotFoundException exception) {
        return new AppExceptionResponse(exception.getMessage(), exception.getErrorCode());
    }


}
