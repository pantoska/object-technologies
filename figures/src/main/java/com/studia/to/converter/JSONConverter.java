package com.studia.to.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.studia.to.shapeInterface.ShapeEntity;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class JSONConverter {
    private final ObjectMapper mapper = new ObjectMapper();

    public JSONConverter() {
    }

    public void convertToJson(List<ShapeEntity> shapeEntityList, String pathname) throws IOException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writerFor(new TypeReference<List<ShapeEntity>>() {
        }).writeValue(new File(pathname), shapeEntityList);
    }

    public List<ShapeEntity> convertToList(String pathname) throws IOException {
        List<ShapeEntity> list = new ArrayList<>();
        list = mapper.readValue(new File(pathname), new TypeReference<List<ShapeEntity>>() {
        });
        return list;
    }
}
