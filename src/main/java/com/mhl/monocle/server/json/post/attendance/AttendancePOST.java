package com.mhl.monocle.server.json.post.attendance;

/**
 *   +-------------------------------------------------------+
 *   | Field | Type   | Description                          |
 *   |-------+--------+--------------------------------------|
 *   | name  | string | Name of the user                     |
 *   | code  | string | Attendance code given by the teacher |
 *   +-------------------------------------------------------+
 */
public class AttendancePOST {
  private String name;
  private String code;

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
