package com.mhl.monocle.server.json;

import com.mhl.monocle.server.MonocleServer;

public class GetStudentsResponse {

  private int status;
  private String message;
  private String[] users;
  private boolean unlocked;

  public GetStudentsResponse(int status, String message, String[] users, boolean unlocked) {
    this.status = status;
    this.message = message;
    this.users = users;
    this.unlocked = unlocked;
  }

  public GetStudentsResponse() {
    this.status = 0;
    this.message = "[message]";
    this.users = new String[MonocleServer.attendance.size()];
    this.unlocked = false;
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

  public String[] getUsers() {
    return users;
  }

  public void setUsers(String[] users) {
    this.users = users;
  }

  public boolean isUnlocked() {
    return unlocked;
  }

  public void setUnlocked(boolean unlocked) {
    this.unlocked = unlocked;
  }
}
