package com.studia.to.validation;

public class Validate {

    public boolean checkInt(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format");
            return false;
        }
        return true;
    }

    public boolean checkDouble(String data) {
        try {
            Double.parseDouble(data);
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format");
            return false;
        }
        return true;
    }
}
