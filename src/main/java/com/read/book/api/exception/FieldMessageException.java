package com.read.book.api.exception;

public class FieldMessageException {

  private String name;
  private String message;

  public FieldMessageException() {
    super();
  }

  public FieldMessageException(String name, String message) {
    this.name = name;
    this.message = message;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
