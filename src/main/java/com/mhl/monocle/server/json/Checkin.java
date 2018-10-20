package com.mhl.monocle.server.json;

public class Checkin {
  private String name;
  private String code;

  public Checkin(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public Checkin() {
    this.name = "[name]";
    this.code = "[code]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
