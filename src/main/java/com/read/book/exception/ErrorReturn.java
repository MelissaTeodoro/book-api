package com.read.book.exception;

public class ErrorReturn {

  private Long timeStamp;
  private Integer status;
  private String error;

  public ErrorReturn() {
    super();
  }

  public ErrorReturn(Long timeStamp, Integer status, String error) {
    this.timeStamp = timeStamp;
    this.status = status;
    this.error = error;
  }

  public Long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Long timeStamp) {
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
