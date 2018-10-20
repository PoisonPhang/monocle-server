package com.mhl.monocle.server.data;

import com.google.gson.Gson;
import com.mhl.monocle.server.MonocleServer;
import com.mhl.monocle.server.json.DataObject;
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

    } else if (type.equals("stopAttendance")) {

    } else if (type.equals("checkin")) {

    } else if (type.equals("getStudents")) {

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
