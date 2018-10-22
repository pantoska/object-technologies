package com.studia.to.view;

import javax.swing.*;
import java.awt.*;

public class ShapeView extends JFrame {
    private Shape shape;
    private Color color = Color.BLACK;
    private Integer thickness = 10;
    private final int width = 800;
    private final int height = 800;

    public ShapeView() throws HeadlessException {
        setSize(width, height);
        setColor(Color.RED);
        setTitle("Paint");
    }

    public void setShape(Shape shape) {
        this.shape = shape;
        revalidate();
        repaint();

    }

    public void setThickness(Integer thickness){
        this.thickness = thickness;
    }

    public void setColor(Color color){
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (shape != null) {
            g2.setPaint(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.fill(shape);
            g2.draw(shape);
        }

        getContentPane().setBackground(Color.BLACK);

    }

}
