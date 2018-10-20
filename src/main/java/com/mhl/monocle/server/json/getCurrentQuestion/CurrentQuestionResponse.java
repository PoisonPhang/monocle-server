package com.mhl.monocle.server.json.getCurrentQuestion;

public class CurrentQuestionResponse {

  private int type;
  private String id;
  private int numChoices;

  public CurrentQuestionResponse(int type, String id, int numChoices) {
    this.type = type;
    this.id = id;
    this.numChoices = numChoices;
  }

  public CurrentQuestionResponse() {
    this.type = 0;
    this.id = "[id]";
    this.numChoices = 0;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getNumChoices() {
    return numChoices;
  }

  public void setNumChoices(int numChoices) {
    this.numChoices = numChoices;
  }
}
