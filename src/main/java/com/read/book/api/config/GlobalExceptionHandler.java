package com.read.book.api.config;

import com.read.book.api.exception.DataIntegrityViolationException;
import com.read.book.api.exception.ErrorReturn;
import com.read.book.api.exception.NotFoundException;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorReturn> handleNotFoundException(NotFoundException e, HttpServletRequest request) {
    ErrorReturn error = new ErrorReturn(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ErrorReturn> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
    ErrorReturn error = new ErrorReturn(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

}
