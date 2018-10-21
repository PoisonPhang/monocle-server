package com.mhl.monocle.server.json;

public class Answer {
  private String name;
  private String answer;

  public Answer(String name, String answer) {
    this.name = name;
    this.answer = answer;
  }

  public Answer() {
    this.name = "[name]";
    this.answer = "[answer]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
