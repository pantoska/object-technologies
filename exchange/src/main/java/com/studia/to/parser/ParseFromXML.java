package com.studia.to.parser;

import com.studia.to.model.CurrencyModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ParseFromXML implements Parser {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    Map<String, CurrencyModel> newCurrencyMap = new HashMap<>();
    Document doc;


    @Override
    public Map<String, CurrencyModel> parse(String source) throws Exception {

        builder = factory.newDocumentBuilder();
        doc = builder.parse(source);


        NodeList currencyList = doc.getElementsByTagName("pozycja");
        //System.out.println(currencyList.getLength());

        for (int i = 0; i < currencyList.getLength(); i++) {
            Node currency = currencyList.item(i);
            Element c = (Element) currency;
            String name = c.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
            String unit = c.getElementsByTagName("przelicznik").item(0).getTextContent();
            String code = c.getElementsByTagName("kod_waluty").item(0).getTextContent();
            String rate = c.getElementsByTagName("kurs_sredni").item(0).getTextContent();
            newCurrencyMap.put(code, map(name,unit,code,rate));

        }

        //System.out.println(newCurrencyMap);

        return newCurrencyMap;
}

    private CurrencyModel map(String name, String unit, String code, String rate) {
        Integer parseUnit = Integer.parseInt(unit);
        Double parseRate = Double.parseDouble(replace(rate));
        return new CurrencyModel(name, parseUnit, code, parseRate);
    }

    private String replace(String value){
        return value.replaceAll(",", ".");
    }
}

