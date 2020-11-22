package com.mildw.minsu.exception;

public class BadRequestException extends RuntimeException {

    private final String errorCode;

    public BadRequestException(String errorCode) {
        super("Bad Request");
        this.errorCode = errorCode;
    }

    public BadRequestException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() { return errorCode;}

}
