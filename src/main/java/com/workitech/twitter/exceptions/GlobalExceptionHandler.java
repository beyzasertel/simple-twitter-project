package com.workitech.twitter.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<UserErrorResponse> handleException(UserException userException){

            UserErrorResponse userErrorResponse = new UserErrorResponse();
            userErrorResponse.setMessage(userException.getMessage());
            userErrorResponse.setStatus(userException.getHttpStatus().value());
            userErrorResponse.setTimestamp(System.currentTimeMillis());
            userErrorResponse.setLocalDateTime(LocalDateTime.now());

            return new ResponseEntity<>(userErrorResponse, userException.getHttpStatus());
    }
}
