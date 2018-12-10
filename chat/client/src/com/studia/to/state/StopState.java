package com.studia.to.state;

import com.studia.to.Client;

import java.net.Socket;

public class StopState implements State {
    private Socket socket;
    private Client client;

    public StopState(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
    }

    @Override
    public void doAction() {

    }
}
