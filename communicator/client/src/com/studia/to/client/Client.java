package com.studia.to.client;

import com.studia.to.state.Context;
import com.studia.to.state.StartState;
import com.studia.to.state.StopState;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Context context;
    private Socket socket;

    public void changeState(){
        if(context.getState() instanceof StopState) {
            String input = ((StopState) context.getState()).getLine();
            context = new Context(new StartState(socket, this, input));
            context.doAction();
        }
         else if (context.getState() instanceof StartState) {
            context = new Context(new StopState(socket, this));
            context.doAction();
        }
    }

    public void run() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), 5000);
        context = new Context(new StopState(socket,this));

        while (true) {
            context.doAction();
        }
    }
}
