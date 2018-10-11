package com.studia.to.parser;

import com.studia.to.model.CurrencyModel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParserFromCSV implements Parser {
    private final String demiliter = ";";

    @Override
    public Map<String, CurrencyModel> parse() throws Exception {
        Scanner scanner = new Scanner(new File("exchange.csv"));
        Map<String, CurrencyModel> newCurrencyMap = new HashMap<>();

        String[] values;

        scanner.useDelimiter(demiliter);
        scanner.nextLine();

        while (scanner.hasNext())
        {
            String name = scanner.nextLine();
            String[] parameters = name.split(demiliter);
            newCurrencyMap.put(parameters[2], map(parameters));
        }
        scanner.close();
        System.out.println(newCurrencyMap);
        return newCurrencyMap;
    }

    private CurrencyModel map(String [] parameters) {
        Integer unit = Integer.parseInt(parameters[1]);
        System.out.println(parameters[1]);
        Double rate = Double.parseDouble(replace(parameters[3]));
        System.out.println(parameters[3]);
        return new CurrencyModel(parameters[0], unit, parameters[2], rate);
    }

    private String replace(String rate){
        return rate.replaceAll(",",".");
    }

}
