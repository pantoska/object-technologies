package com.studia.to.parser;

import com.studia.to.model.CurrencyModel;

import java.util.Map;

public interface Parser {
    Map<String, CurrencyModel> parse() throws Exception;
}
