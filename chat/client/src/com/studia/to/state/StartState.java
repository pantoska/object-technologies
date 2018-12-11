package com.studia.to.state;

import com.studia.to.Client;
import com.studia.to.screenShot.ScreenShot;

import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class StartState implements State {
    private Socket socket;
    private Client client;
    private DataOutputStream dataOutputStream;
    private String line;
    private Scanner scanner = new Scanner(System.in);
    private ScreenShot screenShot = new ScreenShot();


    public StartState(Socket socket, Client client,String line) {
        this.socket = socket;
        this.client = client;
        this.line = line;

        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doAction() {
        System.out.println(line.substring(8));
        try {
            if (line.equals("REQUEST Podaj tekst"))
                sendText();
            else if (line.equals("REQUEST Podaj zdjęcie"))
                sendCapture();
            System.out.println("Sending...");
        } catch (Exception e){
            e.printStackTrace();
        }
        client.changeState();
    }

    private void sendText() throws IOException {
        String words = scanner.nextLine();
        dataOutputStream.writeInt(words.length());
        dataOutputStream.writeUTF("t");
        byte[] sendData = words.getBytes();
        dataOutputStream.write(sendData);
        dataOutputStream.flush();
    }

    private void sendCapture() throws IOException, AWTException {
        screenShot.shootCapture();
        screenShot.getCapture();
        System.out.println("Aby wysłać screenshota wpisz s");
        String response = scanner.next();
        if(response.equals("s")){
            dataOutputStream.writeInt((int) screenShot.getFile().length());
            dataOutputStream.writeUTF("s");
            dataOutputStream.write(screenShot.getSendData(), 0, screenShot.getSendData().length);
        }
    }
}
