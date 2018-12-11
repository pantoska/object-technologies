package com.studia.to;

import com.studia.to.server.Server;

import java.io.*;

public class ServerApp{
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
    }
}



