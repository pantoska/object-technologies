package com.studia.to.repository;

import com.studia.to.controller.Shape;
import java.util.List;

public class FiguresRepository {
    private List<Shape> list;

    public FiguresRepository(List<Shape> list) {
        this.list = list;
    }

    public Shape getShape(int id){
        return list.get(id);
    }

    public List<Shape> getAllShapes(){
        return list;
    }
}
