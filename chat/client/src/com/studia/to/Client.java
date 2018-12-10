package com.studia.to;

import com.studia.to.state.Context;
import com.studia.to.state.StopState;

import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private BufferedReader input;
    private DataOutputStream dataOutputStream;
    private ScreenShot screenShot = new ScreenShot();
    private Context context;

    public void run() throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 5000);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        context = new Context(new StopState(socket,this));

        while (true) {
            String line = input.readLine();
            if (line.startsWith("REQUEST Podaj tekst")) {
                System.out.println(line.substring(8));

                Text text = new Text();
                text.getInput();

                dataOutputStream.writeInt(text.getWords().length());
                byte[] sendData = text.getWords().getBytes();
                dataOutputStream.write(sendData);
                dataOutputStream.flush();

            } else if(line.startsWith("REQUEST Podaj zdjęcie")){
                System.out.println(line.substring(8));

                try {
                    screenShot.shootCapture();
                } catch (AWTException e) {
                    e.printStackTrace();
                }

                screenShot.getCapture();

                dataOutputStream.writeInt((int) screenShot.getFile().length());
                dataOutputStream.write(screenShot.getSendData(), 0, screenShot.getSendData().length);
            }
        }
    }
}
