package com.mildw.minsu.controller.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mildw.minsu.constants.ErrorCodes;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum Error {

    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, ErrorCodes.BAD_REQUEST_INVALID_VALUE, "Invalid Input Value"),
    DATA_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, ErrorCodes.BAD_REQUEST_NOT_FOUND, "Data Not Found Error"),

    AUTHENTICATION_CREDENTIALS_NOT_FOUND_EXCEPTION(HttpStatus.UNAUTHORIZED, "U001", "Unauthenticated"),
    INTERNAL_AUTHENTICATION_SERVICE_EXCEPTION(HttpStatus.UNAUTHORIZED, "U001", "Unauthenticated"),
    BAD_CREDENTIALS(HttpStatus.UNAUTHORIZED, "U002", "Bad Credentials"),
    ;

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;

    Error(final HttpStatus httpStatus, final String errorCode, final String message){
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
