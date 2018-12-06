package com.studia.to;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;


public class ClientHandler implements Runnable {

    //private static ConcurrentMap<String, SessionState.Client> clientsMap = new ConcurrentHashMap<>();
    private static Set<String> clientsSet = new HashSet<>();
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    private String name;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                out.println("SUBMITNAME");
                name = in.readLine();
                if (name == null) {
                    return;
                }
                synchronized (clientsSet) {
                    if (!clientsSet.contains(name)) {
                        clientsSet.add(name);
                        break;
                    }
                }
            }

            out.println("NAMEACCEPTED");
            writers.add(out);

            while (true) {
                String input = in.readLine();
                if (input == null) {
                    return;
                }
                for (PrintWriter writer : writers) {
                    writer.println("MESSAGE " + name + ": " + input);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (name != null) {
                clientsSet.remove(name);
            }
            if (out != null) {
                writers.remove(out);
            }
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}