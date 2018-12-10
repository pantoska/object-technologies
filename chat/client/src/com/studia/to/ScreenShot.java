package com.studia.to;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ScreenShot {
    private File file;
    private byte [] sendData;

    public void shootCapture() throws AWTException, IOException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File("/home/patrycja/programowanie/TO/object-technologies/chat/client/created.jpg"));
    }

    public void getCapture() throws IOException {
        file = new File("/home/patrycja/programowanie/TO/object-technologies/chat/client/created.jpg");
        FileInputStream fin = new FileInputStream(file);
        sendData = new byte[(int) file.length()];
        fin.read(sendData);
    }

    public File getFile(){
        return file;
    }

    public byte[] getSendData(){
        return sendData;
    }
}
