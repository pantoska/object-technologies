package com.studia.to.model;

public class CurrencyModel {
    private String name;
    private String code;
    private Integer unit;
    private Double rate;

    public CurrencyModel() {}

    public CurrencyModel(String name, Integer unit,String code, Double rate) {
        this.name = name;
        this.code = code;
        this.unit = unit;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "\n{\n" +
                "a) name='" + name + '\n' +
                "b) unit=" + unit + '\n' +
                "c) rate=" + rate + '\n' +
                '}' + '\n';
    }
}
