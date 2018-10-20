package com.mhl.monocle.server;

import com.google.gson.Gson;
import com.mhl.monocle.server.data.DataParse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class AndroidServer implements Runnable {

  public Socket clientSocket;

  public AndroidServer(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  public void run() {
    Gson gson = new Gson();
    try {
      InputStream is = clientSocket.getInputStream();
      PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
      byte[] buffer = new byte[1024];
      int read;
      while ((read = is.read(buffer)) != -1) {
        String output = new String(buffer, 0, read);
        System.out.print(output);
        System.out.flush();
        pw.println(gson.toJson(DataParse.parseJson(output)));
        pw.println();
        pw.flush();
      }

      clientSocket.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}