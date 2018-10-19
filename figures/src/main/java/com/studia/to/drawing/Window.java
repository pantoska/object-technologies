package com.studia.to.drawing;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final int width = 700;
    private final int height = 500;

    public void drawShapes(){
        setBounds(100, 100, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0, width, height);

        /*list = view.getList();
        for(int i = 0; i< list.size();i++){
            if(list.get(i) )
            g.setColor(Color.cyan);
            g.fillOval();

        }*/

    }




}
