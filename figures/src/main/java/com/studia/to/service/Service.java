package com.studia.to.service;

import com.studia.to.converter.ConvertListToJson;
import com.studia.to.shapeInterface.Shape;
import com.studia.to.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private View view;
    private ConvertListToJson convertListToJson;
    private List<Shape> list = new ArrayList<>();

    public Service(View view) {
        this.view = view;
    }

    public void getList(){
        list = view.getList();
        convertListToJson = new ConvertListToJson(list);
        try {
            convertListToJson.convert();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getInput(){
        view.getInput();
    }


}
