package com.mhl.monocle.server.data;

import com.google.gson.Gson;
import com.mhl.monocle.server.MonocleServer;
import com.mhl.monocle.server.json.Answer;
import com.mhl.monocle.server.json.Checkin;
import com.mhl.monocle.server.json.DataObject;
import com.mhl.monocle.server.json.GetQuestionDetailsResponse;
import com.mhl.monocle.server.json.GetStudentsResponse;
import com.mhl.monocle.server.json.SpeechToTextRequest;
import com.mhl.monocle.server.json.answerQuestion.AnswerQuestionRequest;
import com.mhl.monocle.server.json.createQuestion.CreateQuestionRequest;
import com.mhl.monocle.server.json.createQuestion.CreateQuestionResponse;
import com.mhl.monocle.server.json.getCurrentQuestion.CurrentQuestionRequest;
import com.mhl.monocle.server.json.getCurrentQuestion.CurrentQuestionResponse;
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
        if (MonocleServer.currentQuestion != null) {
          return new DataObject("getCurrentQuestionResponse", gson.toJson(
              new CurrentQuestionResponse(MonocleServer.currentQuestion.getType(),
                  MonocleServer.currentQuestionId, MonocleServer.currentQuestion.getNumChoices())));
        } else {
          CreateQuestionRequest createQuestionRequest = new CreateQuestionRequest();
          return new DataObject("getCurrentQuestionResponse", "{\"id\":\"0\"}");
        }
      }
    } else if (type.equals("startAttendance")) {
      MonocleServer.attendanceOpen = true;
      MonocleServer.attendanceCode = generateAttendancePIN();
      return new DataObject("Attendance", MonocleServer.attendanceCode);
    } else if (type.equals("stopAttendance")) {
      MonocleServer.attendanceOpen = false;
      return new DataObject("Attendance", "Attendance closed");
    } else if (type.equals("checkin")) {
      Checkin checkin = gson.fromJson(request.getData(), Checkin.class);
      if (MonocleServer.attendanceOpen && checkin.getCode().equals(MonocleServer.attendanceCode)) {
        MonocleServer.attendance.put(checkin.getName(), true);
        MonocleServer.teacherServer.updateTeacher(new DataObject("checkinResponse", checkin.getName()));
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
      return new DataObject("getStudentsResponse", gson.toJson(getStudentsResponse));
    } else if (type.equals("answerQuestion")) {
      if (MonocleServer.questionOpen) {
        AnswerQuestionRequest answerQuestionRequest = gson
            .fromJson(request.getData(), AnswerQuestionRequest.class);
        if (answerQuestionRequest.getId().equals(MonocleServer.currentQuestionId)) {

          for(int i = 0; i < MonocleServer.answers.size(); i++) {
            if (MonocleServer.answers.get(i).getName().equals(answerQuestionRequest.getName())) {
              MonocleServer.answers.set(i, new Answer(answerQuestionRequest.getName(), answerQuestionRequest.getAnswer()));
            }
          }
          MonocleServer.teacherServer.updateTeacher(request);
          return new DataObject("Success", "Question submitted");
        } else {
          return new DataObject("Error", "Question out of date");
        }
      }
    } else if (type.equals("lockQuestion")) {
      MonocleServer.questionOpen = false;
      return new DataObject("Question", "Question Polling closed");
    } else if (type.equals("getQuestionDetails")) {
      if (MonocleServer.currentQuestion != null) {
        Answer[] answersArray = new Answer[MonocleServer.answers.size()];
        for (int i = 0; i < answersArray.length; i++) {
          answersArray[i] = MonocleServer.answers.get(i);
        }
        GetQuestionDetailsResponse getQuestionDetailsResponse = new GetQuestionDetailsResponse(
            MonocleServer.currentQuestion, MonocleServer.questionOpen, answersArray);
        return new DataObject("getQuestionDetailsResponse", gson.toJson(getQuestionDetailsResponse));
      } else {
        GetQuestionDetailsResponse getQuestionDetailsResponse = new GetQuestionDetailsResponse(null, MonocleServer.questionOpen, new Answer[0]);
        return new DataObject("getQuestionDetailsResponse", gson.toJson(getQuestionDetailsResponse));
      }
    } else if (type.equals("removeQuestion")) {
      MonocleServer.currentQuestionId = "0";
      MonocleServer.currentQuestion = null;
      return new DataObject("removeQuestionResponse", "success");
    } else if (type.equals("getAttendanceCode")) {
      String jsonString = "{\"code\":\""+ MonocleServer.attendanceCode + "\", \"attendanceOpen\":\"" + MonocleServer.attendanceOpen + "\"}";
      return new DataObject("getAttendanceCodeResponse", jsonString);
    } else if (type.equals("speechToText")) {
      SpeechToTextRequest speechToTextRequest = gson.fromJson(request.getData(), SpeechToTextRequest.class);
      MonocleServer.teacherServer.updateTeacher(new DataObject("speechToText", gson.toJson(speechToTextRequest)));
      return new DataObject("SpeechToTextResponse", "Sent");
    } else if (type.equals("shutdown")) {
      MonocleServer.running = false;
      return new DataObject("Goodbye", "... cruel world");
    }
    return new DataObject("Error", "Something went wrong");
  }

  private static String generateNewID() {
    char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    Random rnd = new Random();
    boolean pass;
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

  private static String generateAttendancePIN() {
    String pin = "";
    Random random = new Random();

    for (int i = 0; i < 4; i++) {
      int num = random.nextInt(9) + 1;
      pin = pin.concat(Integer.toString(num));
    }
    return pin;
  }
}
