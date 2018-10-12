package com.studia.to.service;


import com.studia.to.calculation.Calculator;
import com.studia.to.controller.Controller;
import com.studia.to.controller.CurrencyController;
import com.studia.to.controller.DigitController;
import com.studia.to.model.CurrencyModel;
import com.studia.to.parser.Parser;
import com.studia.to.repository.CurrencyRepository;
import com.studia.to.view.View;

import java.util.Map;

public class Service {
    private Map<String, CurrencyModel> mapOfCurrency;
    private CurrencyRepository currencyRepository;
    private Controller currencyController;
    private Controller digitController;
    private View view;
    private Parser parser;
    private Calculator calculator;

    public Service(Parser parser) {
        this.parser = parser;
    }

    public void getCSV() {
        try {
            mapOfCurrency = parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkInput() {
        currencyRepository = new CurrencyRepository(mapOfCurrency);
        currencyController = new CurrencyController(currencyRepository);
        digitController = new DigitController();
        calculator = new Calculator(currencyRepository);
        view = new View(currencyController, digitController, calculator);
        view.getInputAmount();
        view.getInputCodeFrom();
        view.getInputCodeTo();
    }

    public void exchangeResult(){
        view.calculate();
    }
}
