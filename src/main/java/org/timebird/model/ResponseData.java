package org.timebird.model;

import java.io.Serializable;

public class ResponseData {
  public static final String STATUS_SUCCESS = "SUCCESS";
  public static final String STATUS_FAILED = "FAILED";

  private Object data;
  private String status;
  private String message;

  public ResponseData(Object data, String status, String message) {
    this.data = data;
    this.status = status;
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
