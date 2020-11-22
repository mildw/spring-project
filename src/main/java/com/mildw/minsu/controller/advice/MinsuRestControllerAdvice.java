package com.mildw.minsu.controller.advice;

import com.mildw.minsu.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MinsuRestControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
        final ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationCredentialsNotFoundException e) {
        final ErrorResponse response = ErrorResponse.of(Error.AUTHENTICATION_CREDENTIALS_NOT_FOUND_EXCEPTION, e.getMessage());
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    protected ResponseEntity<ErrorResponse> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
        final ErrorResponse response = ErrorResponse.of(Error.INTERNAL_AUTHENTICATION_SERVICE_EXCEPTION, e.getMessage());
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
