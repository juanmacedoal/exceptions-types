package com.juanmacedo.exceptionsTypes.model;

/** Class to return a description of the error. */
public class Description {

  private String message;
  private String error;

  /** Description constructor. */
  public Description() {}

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }
}
