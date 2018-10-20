package com.mhl.monocle.server.json.get.question;

/**
 *   +-------------------------------------------------------------------+
 *   | Field      | Type   | Description                                 |
 *   |------------+--------+---------------------------------------------|
 *   | type       | int    | 0 = Short Answer, 1 = Multiple Choice       |
 *   | id         | string | Question id                                 |
 *   | numChoices | string | Number of choices, 0 if not multiple choice |
 *   +-------------------------------------------------------------------+
 */
public class QuestionGET {

  private int type;
  private String id;
  private String numChoices;

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

  public String getNumChoices() {
    return numChoices;
  }

  public void setNumChoices(String numChoices) {
    this.numChoices = numChoices;
  }
}
