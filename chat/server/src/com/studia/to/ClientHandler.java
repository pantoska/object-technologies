package com.studia.to;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private String name;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private DataInputStream dataInputStream;
    private byte[] input;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void sendMessage(String message){
        System.out.println("Sending ..");
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getResponse(){
        System.out.println(input);
    }

    @Override
    public void run() {
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                int length = dataInputStream.readInt();
                input = new byte[length];
                dataInputStream.read(input);
                getResponse();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
