package com.mhl.monocle.server.data;

import com.google.gson.Gson;
import com.mhl.monocle.server.json.DataObject;
import com.mhl.monocle.server.json.createQuestion.CreateQuestionRequest;

public class DataParse {
  public static void parseJson(String json) {
    Gson  gson = new Gson();
    DataObject dataObject = gson.fromJson(json, DataObject.class);
    String type = dataObject.getType();
    if (type.equals("CreateQuestion")) {
      CreateQuestionRequest question = gson.fromJson(dataObject.getData(), CreateQuestionRequest.class);
    }
  }
}
