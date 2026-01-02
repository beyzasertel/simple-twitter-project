package com.workitech.twitter.exceptions;

import org.springframework.http.HttpStatus;

public class TweetNotFoundException extends TweetException {
    public TweetNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
