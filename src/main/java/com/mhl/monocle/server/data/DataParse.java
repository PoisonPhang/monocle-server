package com.mhl.monocle.server.data;

import com.google.gson.Gson;
import com.mhl.monocle.server.MonocleServer;
import com.mhl.monocle.server.json.Answer;
import com.mhl.monocle.server.json.Checkin;
import com.mhl.monocle.server.json.DataObject;
import com.mhl.monocle.server.json.GetQuestionDetailsResponse;
import com.mhl.monocle.server.json.GetStudentsResponse;
import com.mhl.monocle.server.json.answerQuestion.AnswerQuestionRequest;
import com.mhl.monocle.server.json.createQuestion.CreateQuestionRequest;
import com.mhl.monocle.server.json.createQuestion.CreateQuestionResponse;
import com.mhl.monocle.server.json.getCurrentQuestion.CurrentQuestionRequest;
import com.mhl.monocle.server.json.getCurrentQuestion.CurrentQuestionResponse;
import java.util.HashMap;
import java.util.Random;

public class DataParse {

  public static DataObject parseJson(String json) {
    Gson gson = new Gson();
    DataObject request = gson.fromJson(json, DataObject.class);
    String type = request.getType();

    if (type.equals("createQuestion")) {
      MonocleServer.questionOpen = true;
      MonocleServer.currentQuestion = gson.fromJson(request.getData(), CreateQuestionRequest.class);
      MonocleServer.currentQuestionId = generateNewID();
      MonocleServer.questions.put(MonocleServer.currentQuestionId, MonocleServer.currentQuestion);
      return new DataObject("createQuestionResponse", gson
          .toJson(new CreateQuestionResponse(0, "Success")));
    } else if (type.equals("getCurrentQuestion")) {
      CurrentQuestionRequest currentQuestionRequest = gson
          .fromJson(json, CurrentQuestionRequest.class);
      if (!currentQuestionRequest.getId().equals(MonocleServer.currentQuestionId)) {
        return new DataObject("getCurrentQuestionResponse", gson.toJson(
            new CurrentQuestionResponse(MonocleServer.currentQuestion.getType(),
                MonocleServer.currentQuestionId, MonocleServer.currentQuestion.getNumChoices())));
      }
    } else if (type.equals("startAttendance")) {
      MonocleServer.attendanceOpen = true;
      MonocleServer.attendanceCode = "1337"; // TODO generate 4 digit code
      return new DataObject("Attendance", "Attendance open");
    } else if (type.equals("stopAttendance")) {
      MonocleServer.attendanceOpen = false;
      return new DataObject("Attendance", "Attendance closed");
    } else if (type.equals("checkin")) {
      Checkin checkin = gson.fromJson(request.getData(), Checkin.class);
      if (MonocleServer.attendanceOpen && checkin.getCode().equals(MonocleServer.attendanceCode)) {
        MonocleServer.attendance.put(checkin.getName(), true);
        return new DataObject("Checkin", "0");
      } else {
        MonocleServer.attendance.put(checkin.getName(), false);
        return new DataObject("Checkin", "1");
      }
    } else if (type.equals("getStudents")) {
      Object[] students = MonocleServer.attendance.keySet().toArray();
      String[] studentNames = new String[students.length];
      for (int i = 0; i < students.length; i++) {
        studentNames[i] = students[i].toString();
      }
      GetStudentsResponse getStudentsResponse = new GetStudentsResponse(0, "", studentNames,
          MonocleServer.attendanceOpen);
      return new DataObject("getStudentsRespons", gson.toJson(getStudentsResponse));
    } else if (type.equals("answerQuestion")) {
      if (MonocleServer.questionOpen) {
        AnswerQuestionRequest answerQuestionRequest = gson
            .fromJson(request.getData(), AnswerQuestionRequest.class);
        if (answerQuestionRequest.getId().equals(MonocleServer.currentQuestionId)) {
          MonocleServer.answers.add(new Answer(answerQuestionRequest.getName(), answerQuestionRequest.getAnswer()));
          MonocleServer.teacherServer.updateTeacher(request);
          return new DataObject("Success", "Question submitted");
        } else {
          return new DataObject("Error", "Question out of date");
        }
      }
    } else if (type.equals("lockQuestion")) {
      MonocleServer.questionOpen = false;
      return new DataObject("Attendance", "AttendanceClosed");
    } else if (type.equals("getQuestionDetails")) {
      Answer[] answersArray = new Answer[MonocleServer.answers.size()];
      for (int i = 0; i < answersArray.length; i++) {
        answersArray[i] = MonocleServer.answers.get(i);
      }
      GetQuestionDetailsResponse getQuestionDetailsResponse = new GetQuestionDetailsResponse(
          MonocleServer.currentQuestion, MonocleServer.questionOpen, answersArray);
      return new DataObject("getQuestionDetailsResponse", gson.toJson(getQuestionDetailsResponse));
    }
    return new DataObject("Error", "Something went wrong");
  }

  private static String generateNewID() {
    char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    Random rnd = new Random();
    boolean pass = false;
    StringBuilder sb;

    do {
      sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
      for (int i = 0; i < 5; i++) {
        sb.append(chars[rnd.nextInt(chars.length)]);
      }
      if (MonocleServer.questions.containsKey(sb.toString())) {
        pass = false;
      } else {
        pass = true;
      }
    } while (!pass);
    return sb.toString();
  }

}
