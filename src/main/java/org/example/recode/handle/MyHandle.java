package org.example.recode.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyHandle {
    @ExceptionHandler
    public ResponseEntity<ErrorMessager> checkAll(Exception ex){
        ErrorMessager error  = new ErrorMessager(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
