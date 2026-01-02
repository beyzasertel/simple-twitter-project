package com.workitech.twitter.exceptions;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExists extends UserException {
    public EmailAlreadyExists(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
