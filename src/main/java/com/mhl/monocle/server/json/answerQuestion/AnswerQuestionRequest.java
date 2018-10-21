package com.mhl.monocle.server.json.answerQuestion;

public class AnswerQuestionRequest {

  private String id;
  private String name;
  private String answer;

  public AnswerQuestionRequest(String id, String name, String answer) {
    this.id = id;
    this.name = name;
    this.answer = answer;
  }

  public AnswerQuestionRequest() {
    this.id = "[id]";
    this.name = "[name]";
    this.answer = "[answer]";
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
