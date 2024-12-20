package com.example.dx_admindashboard.exception.controller;

import com.example.dx_admindashboard.exception.FirebaseException;
import com.example.dx_admindashboard.exception.ListEmptyException;
import com.example.dx_admindashboard.exception.ObjectEmptyException;
import com.example.dx_admindashboard.exception.dto.ErrorDTO;
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

    @ExceptionHandler(FirebaseException.class)
    protected ResponseEntity<ErrorDTO> firebaseExceptionHandler(FirebaseException e) {
        return new ResponseEntity<>(ErrorDTO.of("파이어베이스 예외입니다."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ListEmptyException.class)
    protected ResponseEntity<ErrorDTO> listEmptyExceptionHandler(ListEmptyException le) {
        return new ResponseEntity<>(ErrorDTO.of("리스트가 비어있습니다."), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObjectEmptyException.class)
    protected ResponseEntity<ErrorDTO> objectEmptyExceptionHandler(ObjectEmptyException oe) {
        return new ResponseEntity<>(ErrorDTO.of("객체가 비어있습니다"), HttpStatus.NOT_FOUND);
    }

}
