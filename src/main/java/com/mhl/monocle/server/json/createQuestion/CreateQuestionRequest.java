package com.mhl.monocle.server.json.createQuestion;

public class CreateQuestionRequest {
  private String question;
  private int type;
  private int numChoices;
  private String[] choices;

  public CreateQuestionRequest(String question, int type, int numChoices, String[] choices) {
    this.question = question;
    this.type = type;
    this.numChoices = numChoices;
    this.choices = choices;
  }

  public CreateQuestionRequest() {
    this.question = "[question]";
    this.type = 0;
    this.numChoices = 0;
    this.choices = new String[numChoices];
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getNumChoices() {
    return numChoices;
  }

  public void setNumChoices(int numChoices) {
    this.numChoices = numChoices;
  }

  public String[] getChoices() {
    return choices;
  }

  public void setChoices(String[] choices) {
    this.choices = choices;
  }
}
