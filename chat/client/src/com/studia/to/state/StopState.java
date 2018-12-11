package com.studia.to.state;

import com.studia.to.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class StopState implements State {
    private Socket socket;
    private Client client;
    private BufferedReader input;
    private String line;

    public StopState(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doAction() {
        try {
            line = input.readLine();
            client.changeState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getLine(){
        return line;
    }
}
