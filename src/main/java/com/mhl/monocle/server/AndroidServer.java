package com.mhl.Android.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AndroidServer implements Runnable {
    public Socket clientSocket;

    public AndroidServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
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
    }
}