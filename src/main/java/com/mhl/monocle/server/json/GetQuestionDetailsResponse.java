package com.mhl.monocle.server.json;

import com.mhl.monocle.server.MonocleServer;
import com.mhl.monocle.server.json.createQuestion.CreateQuestionRequest;

public class GetQuestionDetailsResponse {

  private CreateQuestionRequest question;
  private boolean unlocked;
  private Answer[] answers;

  public GetQuestionDetailsResponse(
      CreateQuestionRequest question, boolean unlocked, Answer[] answers) {
    this.question = question;
    this.unlocked = unlocked;
    this.answers = answers;
  }

  public GetQuestionDetailsResponse() {
    this.question = new CreateQuestionRequest();
    this.unlocked = false;
    this.answers = new Answer[MonocleServer.answers.size()];
  }

  public CreateQuestionRequest getQuestion() {
    return question;
  }

  public void setQuestion(CreateQuestionRequest question) {
    this.question = question;
  }

  public boolean isUnlocked() {
    return unlocked;
  }

  public void setUnlocked(boolean unlocked) {
    this.unlocked = unlocked;
  }

  public Answer[] getAnswers() {
    return answers;
  }

  public void setAnswers(Answer[] answers) {
    this.answers = answers;
  }
}
