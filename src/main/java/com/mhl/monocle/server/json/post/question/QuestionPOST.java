package com.mhl.monocle.server.json.post.question;

/**
 *   +---------------------------------------------------------------+
 *   | Field      | Type     | Description                           |
 *   |------------+----------+---------------------------------------|
 *   | question   | string   | Name of the user                      |
 *   | type       | int      | 0 = Short Answer, 1 = Multiple Choice |
 *   | numChoices | string   | Answer to the question                |
 *   | choices    | String[] | Choices if type is = to 1             |
 *   +---------------------------------------------------------------+
 */
public class QuestionPOST {
  private String question;
  private int type;
  private String numChoices;
  private String[] choices;

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

  public String getNumChoices() {
    return numChoices;
  }

  public void setNumChoices(String numChoices) {
    this.numChoices = numChoices;
  }

  public String[] getChoices() {
    return choices;
  }

  public void setChoices(String[] choices) {
    this.choices = choices;
  }
}
