package com.studia.to.service;

import com.studia.to.repository.FiguresRepository;
import com.studia.to.shapeInterface.ShapeEntity;

import java.util.List;

public class ShapeService {
    private final FiguresRepository figuresRepository;

    public ShapeService(FiguresRepository figuresRepository) {
        this.figuresRepository = figuresRepository;
    }

    public void save(ShapeEntity shapeEntity) {
        figuresRepository.save(shapeEntity);
    }

    public ShapeEntity getShape(int id) {
        return figuresRepository.getShape(id);
    }

    public List<ShapeEntity> getAllShapes() {
        return figuresRepository.getAllShapes();
    }

    public void removeAll() {
        figuresRepository.removeAll();
    }

    public void saveAll(List<ShapeEntity> shapes) {
        figuresRepository.saveAll(shapes);
    }
}
