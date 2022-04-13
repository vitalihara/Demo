package org.vh.involvement.involvementtask.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppExceptionResponse {
    private final String message;
    private final String errorCode;
    private String field;

    AppExceptionResponse(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
