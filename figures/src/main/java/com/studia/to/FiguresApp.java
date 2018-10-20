package com.studia.to;

import com.studia.to.controller.FigureController;
import com.studia.to.view.ShapeView;
import com.studia.to.repository.FiguresRepository;
import com.studia.to.service.ShapeService;

import java.awt.*;

public class FiguresApp {

    public static void main(String[] args) {
        FiguresRepository figuresRepository = new FiguresRepository();
        ShapeService shapeService = new ShapeService(figuresRepository);
        ShapeView shapeView = new ShapeView();
        EventQueue.invokeLater(() -> {
            FigureController figureController = new FigureController(shapeService, shapeView);
            figureController.init();
            figureController.start();
        });

    }
}
