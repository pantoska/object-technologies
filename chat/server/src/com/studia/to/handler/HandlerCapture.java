package com.studia.to.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HandlerCapture extends HandlerMessage{
    @Override
    public void handle(String type, byte[] input) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("/home/patrycja/programowanie/TO/object-technologies/chat/server/received.jpg"));
            fos.write(input);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
