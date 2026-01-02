package com.workitech.twitter.exceptions;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistException extends UserException {
    public UsernameAlreadyExistException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
