package com.studia.to.calculation;

import com.studia.to.model.CurrencyModel;
import com.studia.to.repository.CurrencyRepository;

import java.util.Map;

public class Calculator {
    private CurrencyRepository currencyRepository;

    public Calculator(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    public double calculate(double amount, CurrencyModel currencyModelFrom, CurrencyModel currencyModelTo){
        return amount*currencyModelFrom.getRate() / (currencyModelTo.getRate() * currencyModelTo.getUnit());
    }

    public CurrencyModel getCurrencyByCode(String code){
        return currencyRepository.getCurrencyByCode(code);
    }

    public CurrencyRepository getAllCurrency(){
        return currencyRepository;
    }
}
