package com.mhl.monocle.server.json.request.question;

/**
 *   +------------------------------------------+
 *   | Field     | Type   | Description         |
 *   |-----------+--------+---------------------|
 *   | currentId | string | current question id |
 *   +------------------------------------------+
 */
public class QuestionREQUEST {
  private String currentId;

  public String getCurrentId() {
    return currentId;
  }

  public void setCurrentId(String currentId) {
    this.currentId = currentId;
  }
}
