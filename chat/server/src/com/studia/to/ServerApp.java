package com.studia.to;

import java.io.*;
import java.net.ServerSocket;

public class ServerApp{
    private static final int port = 5000;

    public static void main(String[] args) throws IOException {
        System.out.println("The server is running.");
        ServerSocket listener = new ServerSocket(port);
        try {
            while (true) {
                new Thread(new ClientHandler(listener.accept())).start();
            }
        } finally {
            listener.close();
        }
    }
}



