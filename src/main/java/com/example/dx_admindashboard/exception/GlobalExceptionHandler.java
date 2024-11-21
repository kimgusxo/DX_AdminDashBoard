package com.example.dx_admindashboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDTO> commonExceptionHandler(Exception e) {
        return new ResponseEntity<>(ErrorDTO.of("알 수 없는 예외입니다."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
