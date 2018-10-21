package com.mhl.monocle.server;

import com.google.gson.Gson;
import com.mhl.monocle.server.data.DataParse;
import com.mhl.monocle.server.json.DataObject;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;


public class TeacherServer extends WebSocketServer {

  private WebSocket teacherConnection;
  private Gson gson;

  public TeacherServer(int port) throws UnknownHostException {
    super(new InetSocketAddress(port));
    gson = new Gson();
  }

  public TeacherServer(InetSocketAddress address) {
    super(address);
  }

  //USE THESE METHODS FOR TEACHER FRONTEND
  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
    System.out.println(
        conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!");
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    System.out.println(conn + " has left the room!");
  }

  @Override
  public void onMessage(WebSocket conn, String message) {

    teacherConnection = conn;
    System.out.println(conn + ": " + message);
    conn.send(gson.toJson(DataParse.parseJson(message)));
  }

  @Override
  public void onMessage(WebSocket conn, ByteBuffer message) {
    conn.send(message);
    System.out.println(conn + ": " + message);
  }

  @Override
  public void onError(WebSocket conn, Exception ex) {
    ex.printStackTrace();
    if (conn != null) {
      // some errors like port binding failed may not be assignable to a specific websocket
    }
  }

  public void updateTeacher(DataObject dataObject) {
    String message = gson.toJson(dataObject);
    System.out.println(teacherConnection + "-TUpdate: " + message);
    teacherConnection.send(message);
  }

  @Override
  public void onStart() {
    System.out.println("Server started!");
    setConnectionLostTimeout(0);
    setConnectionLostTimeout(100);
  }
}