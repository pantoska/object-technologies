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
    private Map<String, CurrencyModel> mapOfCurrencyCSV;
    private Map<String, CurrencyModel> mapOfCurrencyXML;
    private CurrencyRepository currencyRepository;
    private Controller currencyController;
    private Controller digitController;
    private View view;
    private Parser parserCSV;
    private Parser parserXML;
    private Calculator calculator;
    private String sourceXML = "https://www.nbp.pl/kursy/xml/lastA.xml";
    private String sourceCSV = "exchange.csv";

    public Service(Parser parserCSV, Parser parserXML) {
        this.parserCSV = parserCSV;
        this.parserXML = parserXML;
    }

    public void getCSV() {
        try {
            mapOfCurrencyCSV = parserCSV.parse(sourceCSV);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getXML(){
        try{
            mapOfCurrencyXML = parserXML.parse(sourceXML);
        } catch (Exception e) {
            System.out.println("Cant get mapOfCurrency in XML");
        }

    }

    public void checkInput() {
        currencyController = new CurrencyController(currencyRepository);
        digitController = new DigitController();
        calculator = new Calculator(currencyRepository);
        view = new View(currencyController, digitController, calculator);
        view.getInputAmount();
        view.getInputCodeFrom();
        view.getInputCodeTo();
    }

    public void exchangeResult(){
        view.viewCalculation();
    }

    public void showRates() {
        currencyRepository = new CurrencyRepository(mapOfCurrencyCSV);
        System.out.println(currencyRepository.getAllCurrency());
    }

}