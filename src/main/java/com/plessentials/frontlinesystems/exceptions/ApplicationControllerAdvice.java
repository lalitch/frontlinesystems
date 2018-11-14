package com.plessentials.frontlinesystems.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(ErrorResponseException.class)
    public ResponseEntity<ErrorInfo> handleException(HttpServletRequest request, ErrorResponseException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(new ErrorInfo(ex.getMessage()));
    }
}
