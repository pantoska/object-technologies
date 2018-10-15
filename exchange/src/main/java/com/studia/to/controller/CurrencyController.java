package com.studia.to.controller;

import com.studia.to.repository.CurrencyRepository;

public class CurrencyController implements Controller {
    private CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public boolean check(String data) {
        if (currencyRepository.getCurrencyByCode(data) == null)
            return false;
        return true;
    }
}
