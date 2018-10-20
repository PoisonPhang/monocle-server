package com.mhl.monocle.server;

import com.mhl.monocle.server.json.createQuestion.CreateQuestionRequest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class MonocleServer {

  public static CreateQuestionRequest currentQuestion;
  public static String currentQuestionId;
  public static Map questions;
  public static TeacherServer teacherServer;
  public static Map answers;
  public static Map userSub;
  public static Map attendance;
  public static boolean attendanceOpen;
  public static boolean questionOpen;
  public static String attendanceCode;

  public static void main(String[] args) throws InterruptedException, IOException {
    questions = new HashMap();
    answers = new HashMap();
    attendance = new HashMap();
    attendanceOpen = false;
    questionOpen = false;
    int port = 1337; // 843 flash policy port
    try {
      port = Integer.parseInt(args[0]);
    } catch (Exception ex) {
    }
    teacherServer = new TeacherServer(port);
    teacherServer.start();
    System.out.println("TeacherServer started on port: " + teacherServer.getPort());

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