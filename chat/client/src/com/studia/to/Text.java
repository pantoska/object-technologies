package com.studia.to;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text {
    private BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    private String words;


    public void getInput() throws IOException {
        words = scanner.readLine();
    }

    public String getWords() {
        return words;
    }
}
