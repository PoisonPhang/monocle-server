package com.mhl.monocle.server.json.post.attendance;

/**
 *   +-------------------------------------------------------+
 *   | Field | Type   | Description                          |
 *   |-------+--------+--------------------------------------|
 *   | user  | string | Name of the user                     |
 *   | code  | string | Attendance code given by the teacher |
 *   +-------------------------------------------------------+
 */
public class AttendancePOST {
  private String user;
  private String code;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
