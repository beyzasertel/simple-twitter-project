package com.workitech.twitter.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TweetException extends RuntimeException {
    private HttpStatus httpStatus;

    public TweetException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
