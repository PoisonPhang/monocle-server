package com.mhl.monocle.server.json;

public class SpeechToTextRequest {
  private String text;

  public SpeechToTextRequest(String text) {
    this.text = text;
  }

  public SpeechToTextRequest() {
    this.text = "[text]";
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
