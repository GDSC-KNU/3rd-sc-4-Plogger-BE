package com.gdsc.plogger.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({
            IllegalArgumentException.class
    })
    public ResponseEntity<Object> BadRequestException(final RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
