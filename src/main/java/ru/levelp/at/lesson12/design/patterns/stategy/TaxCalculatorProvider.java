package ru.levelp.at.lesson12.design.patterns.stategy;

import java.math.BigDecimal;

public interface TaxCalculatorProvider {

    BigDecimal calculate(final BigDecimal income);
}
