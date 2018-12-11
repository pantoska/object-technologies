package com.studia.to.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Server {
    private static final int port = 5000;
    private final Set<ClientHandler> clients = new HashSet<>();
    private ServerSocket listener;
    private Scanner scanner = new Scanner(System.in);
    private String request;

    private void notifyAllClients(String message) {
        for(ClientHandler clientHandler: clients)
                clientHandler.sendMessage(message);
    }

    private String giveCommand(){
        if(request.equals("s"))
            return "Send screenshot";
        else if(request.equals("t"))
            return "Send text";
        return null;
    }

    public void remove(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public void run() throws IOException {
        System.out.println("The server is running.");
        listener = new ServerSocket(port);
        listen();
        try {
            while (true) {
                System.out.println("Commmand: screenshot(s) text(t)");
                request = scanner.next();
                notifyAllClients(giveCommand());
            }
        }
        finally {
            listener.close();
        }
    }

    public void listen(){
        new Thread(() -> {
            ClientHandler clientHandler = null;
            try {
                while(true) {
                    new Thread(clientHandler = new ClientHandler(listener.accept(),this)).start();
                    clients.add(clientHandler);
                    System.out.println("Add new client");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
