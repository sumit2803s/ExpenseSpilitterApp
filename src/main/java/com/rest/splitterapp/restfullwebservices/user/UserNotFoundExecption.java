package com.rest.splitterapp.restfullwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundExecption extends RuntimeException {
    public UserNotFoundExecption(String message) {
        super(message);
    }

}

