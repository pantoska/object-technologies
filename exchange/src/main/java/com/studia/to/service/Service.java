package com.studia.to.service;

import com.studia.to.parser.Parser;

public class Service {
    private  Parser parser;

    public Service(Parser parser) {
        this.parser = parser;
    }

    public void getCSV(){
        try {
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
