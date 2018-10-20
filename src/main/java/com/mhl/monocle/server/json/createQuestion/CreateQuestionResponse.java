package com.mhl.monocle.server.json.createQuestion;

public class CreateQuestionResponse {
  private int status;
  private String message;

  public CreateQuestionResponse(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public CreateQuestionResponse() {
    this.status = 0;
    this.message = "[message]";
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
