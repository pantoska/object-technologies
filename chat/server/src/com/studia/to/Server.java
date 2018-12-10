package com.studia.to;

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

    private void getResponse(){
        clients.forEach(clients -> clients.getResponse());
    }

    public void notifyAllClients(String message) {
        clients.forEach(client -> client.sendMessage(message));
    }

    private String giveCommand(){
        if(request.equals("z"))
            return "REQUEST Podaj zdjęcie";
        else if(request.equals("t"))
            return "REQUEST Podaj tekst";
        return null;
    }

    public void run() throws IOException {
        System.out.println("The server is running.");
        listener = new ServerSocket(port);
        try {
            while (true) {
                listen();
                System.out.println("Podaj czy chcesz zdjęcie(z) czy tekst(t)");
                request = scanner.next();
                notifyAllClients(giveCommand());
            }
        } finally {
            listener.close();
        }
    }

    public void listen() throws IOException {
        new Thread(() -> {
            ClientHandler clientHandler = null;
            try {
                new Thread(clientHandler = new ClientHandler(listener.accept())).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clients.add(clientHandler);
            System.out.println("Dodano nowego klienta");
        }).start();
    }

}
