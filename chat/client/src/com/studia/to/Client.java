package com.studia.to;

import java.io.*;
import java.net.Socket;

public class Client {

    private PrintWriter output;
    private BufferedReader input;
    private BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    private DataOutputStream dataOutputStream;

    public Client() { }

    public void run() throws IOException {

        Socket socket = new Socket("192.168.0.21", 5000);
        input = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String line = input.readLine();
//            System.out.println(line);
            if (line.startsWith("REQUEST")) {
                System.out.println(line.substring(8));
                dataOutputStream.write(scanner.read());
            }
        }
    }
}
