package com.mhl.monocle.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MonocleServer implements Runnable {
  Socket clientSocket;

  MonocleServer(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  public static void main(String args[]) throws Exception {
    ServerSocket serverSocket = new ServerSocket(1337);
    System.out.println("Listening");
    System.out.println(serverSocket.getInetAddress().getHostAddress());

    while (true) {
      Socket sock = serverSocket.accept();
      System.out.println("Connected");
      new Thread(new MonocleServer(sock)).start();
    }
  }

  public void run() {
    try {
      InputStream is = clientSocket.getInputStream();
      PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
      pw.println(1);
      pw.println();
      pw.flush();
      byte[] buffer = new byte[1024];
      int read;
      while((read = is.read(buffer)) != -1) {
        String output = new String(buffer, 0, read);
        System.out.print(output);
        System.out.flush();
      }
      clientSocket.close();
    } catch (IOException e) {
      System.out.println(e);
    }

//    try {
//      InputStream inputStream = clientSocket.getInputStream();
//      PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
//
//      byte[] buffer = new byte[1024];
//      int read;
//      while ((read = inputStream.read(buffer)) != -1) {
//        String output = new String(buffer, 0, read);
//
//      }
//
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }
}
