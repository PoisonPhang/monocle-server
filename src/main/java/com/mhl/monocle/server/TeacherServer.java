package com.mhl.monocle.server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;


public class TeacherServer extends WebSocketServer {

    public TeacherServer( int port ) throws UnknownHostException {
        super( new InetSocketAddress( port ) );
    }

    public TeacherServer( InetSocketAddress address ) {
        super( address );
    }

    //USE THESE METHODS FOR TEACHER FRONTEND
    @Override
    public void onOpen( WebSocket conn, ClientHandshake handshake ) {
        System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!" );
    }

    @Override
    public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
        System.out.println( conn + " has left the room!" );
    }

    @Override
    public void onMessage( WebSocket conn, String message ) {
        conn.send( message );
        System.out.println( conn + ": " + message );
    }

    @Override
    public void onMessage( WebSocket conn, ByteBuffer message ) {
        conn.send(message);
        System.out.println( conn + ": " + message );
    }

    @Override
    public void onError( WebSocket conn, Exception ex ) {
        ex.printStackTrace();
        if( conn != null ) {
            // some errors like port binding failed may not be assignable to a specific websocket
        }
    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
        setConnectionLostTimeout(0);
        setConnectionLostTimeout(100);
    }
}