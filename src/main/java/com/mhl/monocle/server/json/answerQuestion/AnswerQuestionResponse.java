package com.mhl.monocle.server.json.answerQuestion;

/**
 * +-----------+----------+----------------------+
 * |  Field    | 	Type    | 	Description        |
 * +-----------+----------+----------------------+
 * |  status   | 	int     | 	0 = Ok, 1 = Error  |
 * |  message  | 	string  | 	Optional message   |
 * +-----------+----------+----------------------+
 */
public class AnswerQuestionResponse {

  /**
   * 0 = Ok, 1 = Error
   */
  private int status;

  /**
   * Optional message
   */
  private String message;

  /**
   * Full constructor for creating a {@link AnswerQuestionResponse}
   * @param status 0 = Ok, 1 = Error
   * @param message Optional message
   */
  public AnswerQuestionResponse(int status, String message) {
    this.status = status;
    this.message = message;
  }

  /**
   * Default constructor for creating a {@link AnswerQuestionResponse}
   */
  public AnswerQuestionResponse() {
    this.status = 0;
    this.message = "[message]";
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
