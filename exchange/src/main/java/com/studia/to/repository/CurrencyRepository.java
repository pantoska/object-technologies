package com.studia.to.repository;

import com.studia.to.model.CurrencyModel;

import java.util.Map;

public class CurrencyRepository {
    private Map<String, CurrencyModel> mapOfCurrency;

    public CurrencyRepository(Map<String, CurrencyModel> mapOfCurrency) {
        this.mapOfCurrency = mapOfCurrency;
    }

    public CurrencyModel getCurrencyByCode(String code) {
        return mapOfCurrency.get(code);
    }

    public Map<String, CurrencyModel> getAllCurrency() {
        return mapOfCurrency;
    }
}

