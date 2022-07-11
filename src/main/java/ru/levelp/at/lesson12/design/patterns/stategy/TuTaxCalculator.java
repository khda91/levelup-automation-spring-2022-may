package ru.levelp.at.lesson12.design.patterns.stategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TuTaxCalculator implements TaxCalculator {

    private static final BigDecimal TAX_RATE_INCOME_LESS_1000 = new BigDecimal("0.10");
    private static final BigDecimal TAX_RATE_INCOME_BETWEEN_1000_3000 = new BigDecimal("0.24");
    private static final BigDecimal TAX_RATE_INCOME_GREATER_3000 = new BigDecimal("0.35");

    @Override
    public BigDecimal calculate(BigDecimal income) {
        if (income.compareTo(new BigDecimal("1000.00")) < 0) {
            return TAX_RATE_INCOME_LESS_1000.multiply(income).setScale(2, RoundingMode.HALF_UP);
        } else if (income.compareTo(new BigDecimal("1000.00")) >= 0
            && income.compareTo(new BigDecimal("3000.00")) < 0) {
            return TAX_RATE_INCOME_BETWEEN_1000_3000.multiply(income).setScale(2, RoundingMode.HALF_UP);
        } else {
            return TAX_RATE_INCOME_GREATER_3000.multiply(income).setScale(2, RoundingMode.HALF_UP);
        }
    }
}
