package com.mildw.minsu.controller.advice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String errorCode;
    private String message;
    private List<FieldError> errors;

    public ErrorResponse(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
        this.errors = new ArrayList<>();
    }

    public ErrorResponse(final Error error, List<FieldError> errors) {
        this.httpStatus = error.getHttpStatus();
        this.errorCode = error.getErrorCode();
        this.message = error.getMessage();
        this.errors = errors;
    }

    public ErrorResponse(Error error) {
        this.httpStatus = error.getHttpStatus();
        this.errorCode = error.getErrorCode();
        this.message = error.getMessage();
        this.errors = new ArrayList<>();
    }

    public ErrorResponse(Error error, String message) {
        this.httpStatus = error.getHttpStatus();
        this.errorCode = error.getErrorCode();
        this.message = message;
        this.errors = new ArrayList<>();
    }

    public static ErrorResponse of(final Error error, final BindingResult bindingResult) {
        return new ErrorResponse(error, FieldError.of(bindingResult));
    }

    public static ErrorResponse of(final Error code) {
        return new ErrorResponse(code);
    }

    public static ErrorResponse of(final Error code, final String message) {
        if (message.isEmpty()) {
            return new ErrorResponse(code);
        }else {
            return new ErrorResponse(code, message);
        }
    }

    @Getter
    @NoArgsConstructor
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        private FieldError(final String field, final String value, final String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static List<FieldError> of(final String field, final String value, String reason) {
            List<FieldError> fieldErrors = new ArrayList<>();
            fieldErrors.add(new FieldError(field, value, reason));
            return fieldErrors;
        }

        private static List<FieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage())
                    ).collect(Collectors.toList());
        }
    }
}
