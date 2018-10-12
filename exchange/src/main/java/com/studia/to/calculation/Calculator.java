package com.studia.to.calculation;

import com.studia.to.model.CurrencyModel;
import com.studia.to.repository.CurrencyRepository;


public class Calculator {
    private CurrencyRepository currencyRepository;

    public Calculator(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public double calculate(double amount, String currencyFrom, String currencyTo) {
        CurrencyModel currencyModelFrom = getCurrencyByCode(currencyFrom);
        CurrencyModel currencyModelTo = getCurrencyByCode(currencyTo);
        return amount * currencyModelFrom.getRate()/ currencyModelFrom.getUnit()/(currencyModelTo.getRate()) * currencyModelTo.getUnit();
    }

    public CurrencyModel getCurrencyByCode(String code) {
        return currencyRepository.getCurrencyByCode(code);
    }

    public CurrencyRepository getAllCurrency() {
        return currencyRepository;
    }
}
