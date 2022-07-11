package ru.levelp.at.lesson12.design.patterns.stategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RuTaxCalculator implements TaxCalculator {

    private static final BigDecimal TAX_RATE_INCOME = new BigDecimal("0.13");

    @Override
    public BigDecimal calculate(BigDecimal income) {
        return TAX_RATE_INCOME.multiply(income).setScale(2, RoundingMode.HALF_UP);
    }
}
