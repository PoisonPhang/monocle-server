package com.mhl.monocle.server.json;

import com.mhl.monocle.server.json.createQuestion.CreateQuestionRequest;

public class GetQuestionDetailsResponse {

  private CreateQuestionRequest question;
  private boolean status;

  public GetQuestionDetailsResponse(
      CreateQuestionRequest question, boolean status) {
    this.question = question;
    this.status = status;
  }

  public GetQuestionDetailsResponse() {
    this.question = new CreateQuestionRequest();
    this.status = false;
  }

  public CreateQuestionRequest getQuestion() {
    return question;
  }

  public void setQuestion(CreateQuestionRequest question) {
    this.question = question;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
