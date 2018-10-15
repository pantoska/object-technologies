package com.studia.to.view;

import com.studia.to.calculation.Calculator;
import com.studia.to.controller.Controller;

import java.util.Scanner;

public class View {
    private String codeFrom;
    private String codeTo;
    private Double amount;
    private Controller currencyController;
    private Controller digitController;
    private final Calculator calculator;
    Scanner reader = new Scanner(System.in);

    public View(Controller currencyController, Controller digitController, Calculator calculator) {
        this.currencyController = currencyController;
        this.calculator = calculator;
        this.digitController = digitController;
    }

    public void getInputCodeFrom() {
        System.out.println("Podaj kod waluty początkowej: ");
        String input = reader.next();
        if (currencyController.check(input)) {
            System.out.println("Istnieje taki kod w bazie");
            codeFrom = input;
        } else {
            System.out.println("Nie istnieje taki kod w bazie");
            System.exit(-1);
        }
    }

    public void getInputAmount() {
        System.out.println("Podaj ilość: ");
        String input = reader.next();
        if (digitController.check(input)) {
            System.out.println("Wprowadzono prawidłową ilość");
            amount = Double.parseDouble(input);
        } else {
            System.out.println("Wprowadzono złą ilość");
            System.exit(-1);
        }
    }

    public void getInputCodeTo() {
        System.out.println("Podaj kod waluty docelowej: ");
        String input = reader.next();
        if (currencyController.check(input)) {
            System.out.println("Istnieje taki kod w bazie");
            codeTo = input;
        } else {
            System.out.println("Nie istnieje taki kod w bazie");
            System.exit(-1);
        }
    }

    public void viewCalculation(){
        System.out.println(calculator.calculate(amount, codeFrom, codeTo));
    }

}
