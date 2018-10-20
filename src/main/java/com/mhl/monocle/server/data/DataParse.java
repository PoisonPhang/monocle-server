package com.mhl.monocle.server.data;

import com.google.gson.Gson;
import com.mhl.monocle.server.json.DataObject;

public class DataParse {
  public static String parseJson(String json) {
    Gson gson = new Gson();
    DataObject dataObject = gson.fromJson(json, DataObject.class);

  }
}
