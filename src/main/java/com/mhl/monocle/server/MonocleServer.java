package com.mhl.monocle.server;

import com.mhl.monocle.server.json.Answer;
import com.mhl.monocle.server.json.createQuestion.CreateQuestionRequest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MonocleServer {

  public static CreateQuestionRequest currentQuestion;
  public static String currentQuestionId;
  public static Map questions;
  public static TeacherServer teacherServer;
  public static List<Answer> answers;
  public static Map attendance;
  public static boolean attendanceOpen;
  public static boolean questionOpen;
  public static boolean running;
  public static String attendanceCode;

  public static void main(String[] args) throws IOException {
    questions = new HashMap();
    answers = new ArrayList<Answer>();
    attendance = new HashMap();
    attendanceOpen = false;
    questionOpen = false;
    running = true;
    int port = 1337; // 843 flash policy port
    try {
      port = Integer.parseInt(args[0]);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    teacherServer = new TeacherServer(port);
    teacherServer.start();
    System.out.println("TeacherServer started on port: " + teacherServer.getPort());

    //Android Socket
    ServerSocket serverSocket = new ServerSocket(1336);
    System.out.println("AndroidServer started on port: 1336");
    System.out.println(serverSocket.getInetAddress().getHostAddress());

    Socket socket = null;
    while (running) {
      socket = serverSocket.accept();
      System.out.println("Connected");
      new Thread(new com.mhl.monocle.server.AndroidServer(socket)).start();
    }
    if (socket != null) {
      socket.close();
    }
  }
}