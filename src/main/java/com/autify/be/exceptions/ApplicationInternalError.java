package com.autify.be.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationInternalError extends RuntimeException{
    public ApplicationInternalError(String message) {
        super(message);
    }
}
