package com.mhl.monocle.server.json.answerQuestion;

/**
 * +--------------+---------+----------------------------------------------+
 * |  Field 	    |  Type 	|  Description                                 |
 * +--------------+---------+----------------------------------------------+
 * |  type 	      |  int 	  |  0 = Short Answer, 1 = Multiple Choice       |
 * |  id 	        |  string |  Question id                                 |
 * |  numChoices  |  string |  Number of choices, 0 if not multiple choice |
 * +--------------+---------+----------------------------------------------+
 */
public class AnswerQuestionRequest {

  /**
   * 0 = Short Answer, 1 = Multiple Choice
   */
  private String id;

  /**
   * Question id
   */
  private String name;

  /**
   * Number of choices, 0 if not multiple choice
   */
  private String answer;

  /**
   * Full item constructor for creating a {@link AnswerQuestionRequest}
   *
   * @param id 0 = Short Answer, 1 = Multiple Choice
   * @param name Question id
   * @param answer Number of choices, 0 if not multiple choice
   */
  public AnswerQuestionRequest(String id, String name, String answer) {
    this.id = id;
    this.name = name;
    this.answer = answer;
  }

  /**
   * Default constructor for creating a {@link AnswerQuestionRequest}
   */
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
