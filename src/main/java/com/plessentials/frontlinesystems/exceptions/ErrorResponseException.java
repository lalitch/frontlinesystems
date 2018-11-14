package com.plessentials.frontlinesystems.exceptions;
;
import org.springframework.http.HttpStatus;

public class ErrorResponseException extends RuntimeException {
    private HttpStatus statusCode;
    private String message;

    public ErrorResponseException(HttpStatus statusCode, String message) {
        super(message);

        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
