package com.studia.to.service;

import com.studia.to.controller.Controller;
import com.studia.to.shape.Shape;
import com.studia.to.view.View;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private Controller controller = new Controller();

    public void getList(){
        List<Shape> list = controller.getList();
    }
}
