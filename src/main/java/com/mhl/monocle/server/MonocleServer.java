package com.mhl.monocle.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MonocleServer {


  public static void main(String[] args) throws InterruptedException, IOException {
    int port = 1337; // 843 flash policy port
    try {
      port = Integer.parseInt(args[0]);
    } catch (Exception ex) {
    }
    TeacherServer s = new TeacherServer(port);
    s.start();
    System.out.println("TeacherServer started on port: " + s.getPort());

    //Android Socket
    ServerSocket serverSocket = new ServerSocket(1336);
    System.out.println("AndroidServer started on port: 1336");
    System.out.println(serverSocket.getInetAddress().getHostAddress());

    while (true) {
      Socket sock = serverSocket.accept();
      System.out.println("Connected");
      new Thread(new com.mhl.monocle.server.AndroidServer(sock)).start();

    }
  }
}