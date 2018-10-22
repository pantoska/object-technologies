package com.studia.to.repository;

import com.studia.to.shapeClasses.ShapeEntity;

import java.util.LinkedList;
import java.util.List;

public class FiguresRepository {
    private final List<ShapeEntity> list = new LinkedList<>();

    public void save(ShapeEntity shapeEntity) {
        list.add(shapeEntity);
    }

    public ShapeEntity getShape(int id) {
        return list.get(id);
    }

    public List<ShapeEntity> getAllShapes() {
        return list;
    }

    public void removeAll() {
        list.clear();
    }

    public void saveAll(List<ShapeEntity> shapes) {
        list.addAll(shapes);
    }
}
