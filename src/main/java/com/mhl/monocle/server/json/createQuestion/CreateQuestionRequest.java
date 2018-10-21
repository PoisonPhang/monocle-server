package com.mhl.monocle.server.json.createQuestion;

/**
 * +--------------+------------------+--------------------------------------------+
 * |  Field       | 	Type           | 	Description                               |
 * +--------------+------------------+--------------------------------------------+
 * |  question    | 	string         | 	Question to ask users                     |
 * |  type        | 	int            | 	0 = Short Answer, 1 = Multiple Choice     |
 * |  numChoices  | 	int            | 	Number of choices                         |
 * |  choices     | 	array[string]  | 	Answers for the multiple choice question  |
 * +--------------+------------------+--------------------------------------------+
 */
public class CreateQuestionRequest {

  /**
   * Question to ask users
   */
  private String question;

  /**
   * 0 = Short Answer, 1 = Multiple Choice
   */
  private int type;

  /**
   * Number of choices
   */
  private int numChoices;

  /**
   * Answers for the multiple choice question
   */
  private String[] choices;

  /**
   * Full constructor for creating a {@link CreateQuestionRequest}
   * @param question Question to ask users
   * @param type 0 = Short Answer, 1 = Multiple Choice
   * @param numChoices Number of choices
   * @param choices Answers for the multiple choice question
   */
  public CreateQuestionRequest(String question, int type, int numChoices, String[] choices) {
    this.question = question;
    this.type = type;
    this.numChoices = numChoices;
    this.choices = choices;
  }

  /**
   * Default constructor for creating a {@link CreateQuestionRequest}
   */
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
