package com.studia.to.server;

import com.studia.to.handler.HandlerMessage;
import com.studia.to.handler.HandlerText;
import com.studia.to.state.Context;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private DataInputStream dataInputStream;
    private byte[] input;
    private Context context = new Context();
    private PrintWriter out;
    private HandlerMessage handlerMessage;
    private Server server;


    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        context.setState("Stop");
        handlerMessage = new HandlerText();
        this.server = server;
    }

    public void sendMessage(String message){
        if(context.getState().equals("Stop")) {
            context.setState("Start");
            try {
                System.out.println("Sending...");
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
                while (true) {
                    int length = dataInputStream.readInt();
                    input = new byte[length];
                    String s = dataInputStream.readUTF();
                    dataInputStream.read(input);
                    handlerMessage.handle(s,input);
                    if(handlerMessage instanceof HandlerText)
                        context.setState("Stop");
                }
            } catch (IOException e) {
                server.remove(this);
                System.out.println(e);
            }
    }
}
