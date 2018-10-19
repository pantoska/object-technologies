package com.studia.to.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.studia.to.shapeInterface.Shape;

import java.io.IOException;
import java.util.List;

public class ConvertListToJson {
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Shape> shapeList;

    public ConvertListToJson(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public void convert() throws IOException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = mapper.writerFor(new TypeReference<List<Shape>>() {}).writeValueAsString(shapeList);
        Shape [] shapes = mapper.readValue(arrayToJson, Shape[].class);
//        for(Shape shapeInterface: shapes) {
//            if(shapeInterface instanceof Circle)
//                System.out.println("Circlr");
//        }
        System.out.println(arrayToJson);
    }
}
