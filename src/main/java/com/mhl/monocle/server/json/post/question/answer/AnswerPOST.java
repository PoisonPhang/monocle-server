package com.mhl.monocle.server.json.post.question.answer;

/**
 *   +------------------------------------------+
 *   | Field  | Type   | Description            |
 *   |--------+--------+------------------------|
 *   | user   | string | Name of the user       |
 *   | id     | string | Question id            |
 *   | answer | string | Answer to the question |
 *   +------------------------------------------+
 */
public class AnswerPOST {
  private String user;
  private String id;
  private String answer;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
