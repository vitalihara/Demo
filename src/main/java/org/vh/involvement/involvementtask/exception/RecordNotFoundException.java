package org.vh.involvement.involvementtask.exception;

import lombok.Getter;

@Getter
public class RecordNotFoundException extends AppException {

    public RecordNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }

}
