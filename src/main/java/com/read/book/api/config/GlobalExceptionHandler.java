package com.read.book.api.config;

import com.read.book.api.exception.ErrorReturn;
import com.read.book.api.exception.NotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorReturn> handleNotFoundException(NotFoundException e, HttpServletRequest request) {
    ErrorReturn error = new ErrorReturn(System.currentTimeMillis(),
        HttpStatus.NOT_FOUND.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

}
