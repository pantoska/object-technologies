package com.studia.to;

import com.studia.to.parser.Parser;
import com.studia.to.parser.ParserFromCSV;
import com.studia.to.service.Service;

public class ExchangeRate {

    public static void main(String[] args){
        Parser parser = new ParserFromCSV();
        Service service = new Service(parser);
        service.getCSV();
    }
}
