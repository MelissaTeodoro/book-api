package com.read.book.api.exception;

import java.time.LocalDateTime;

public class ErrorReturn {

  private LocalDateTime timeStamp;
  private Integer status;
  private String error;

  public ErrorReturn() {
    super();
  }

  public ErrorReturn(LocalDateTime timeStamp, Integer status, String error) {
    this.timeStamp = timeStamp;
    this.status = status;
    this.error = error;
  }

  public LocalDateTime getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(LocalDateTime timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
