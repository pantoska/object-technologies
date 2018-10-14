package com.studia.to;

import com.studia.to.parser.ParseFromXML;
import com.studia.to.parser.Parser;
import com.studia.to.parser.ParserFromCSV;
import com.studia.to.service.Service;

public class ExchangeRate {

    public static void main(String[] args) {
        Parser parserCSV = new ParserFromCSV();
        Parser parserXML = new ParseFromXML();
        Service service = new Service(parserCSV, parserXML);
        service.getCSV();
        service.getXML();
        service.checkInput();
        service.exchangeResult();
    }
}
