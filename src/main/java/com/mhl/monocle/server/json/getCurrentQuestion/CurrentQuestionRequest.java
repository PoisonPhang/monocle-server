package com.mhl.monocle.server.json.getCurrentQuestion;

public class CurrentQuestionRequest {

  private String id;

  public CurrentQuestionRequest(String id) {
    this.id = id;
  }

  public CurrentQuestionRequest() {
    this.id = "[id]";
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
