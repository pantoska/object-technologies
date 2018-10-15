package com.studia.to;

import com.studia.to.controller.Controller;
import com.studia.to.controller.DigitController;
import com.studia.to.parser.ParseFromXML;
import com.studia.to.parser.Parser;
import com.studia.to.parser.ParserFromCSV;
import com.studia.to.service.Service;

public class ExchangeRate {

    public static void main(String[] args) {
        Parser parserCSV = new ParserFromCSV();
        Parser parserXML = new ParseFromXML();
        Controller digitController = new DigitController();
        Service service = new Service(parserCSV, parserXML, digitController);
        service.getCSV();
        service.getXML();
        service.showRates();
        service.takeInput();
        service.exchangeResult();
    }
}
