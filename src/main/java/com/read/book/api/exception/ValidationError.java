package com.read.book.api.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErrorReturn {

  private List<FieldMessageException> errors = new ArrayList<>();

  public ValidationError() {
    super();
  }

  public ValidationError(LocalDateTime timeStamp, Integer status, String error) {
    super(timeStamp, status, error);
  }

  public List<FieldMessageException> getErrors() {
    return errors;
  }

  public void addError(String fieldName, String message) {
    this.errors.add(new FieldMessageException(fieldName, message));
  }
}
