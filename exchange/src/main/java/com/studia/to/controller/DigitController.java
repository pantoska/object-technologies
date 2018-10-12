package com.studia.to.controller;

public class DigitController implements Controller {

    @Override
    public boolean check(String data) {
        try {
            Double.parseDouble(data);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
