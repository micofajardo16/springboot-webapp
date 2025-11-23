package com.example.webapp.exception;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    SUCCESS("SUCCESS", "Successful", HttpStatus.OK),
    ERR_UNKNOWN("ERR_UNKNOWN", "An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR),
    ERR_BAD_REQUEST("ERR_BAD_REQUEST", "Invalid request", HttpStatus.BAD_REQUEST),
    ERR_INVALID_NATIONAL_ID("ERR_INVALID_NATIONAL_ID", "Invalid national ID", HttpStatus.BAD_REQUEST),
    ERR_NO_RECORD_FOUND("ERR_NO_RECORD_FOUND", "No record found", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus httpStatusCode;
}
