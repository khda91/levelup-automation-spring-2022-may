package ru.levelp.at.lesson12.design.patterns.strategy;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson12.design.patterns.stategy.RuTaxCalculator;
import ru.levelp.at.lesson12.design.patterns.stategy.TaxCalculator;
import ru.levelp.at.lesson12.design.patterns.stategy.TaxCalculatorProvider;
import ru.levelp.at.lesson12.design.patterns.stategy.TaxCalculatorProviderImpl;
import ru.levelp.at.lesson12.design.patterns.stategy.TuTaxCalculator;

public class TaxCalculatorProviderTest {

    @Test
    public void ruTaxCalculatorTest() {
        TaxCalculatorProvider provider = new TaxCalculatorProviderImpl(new RuTaxCalculator());
        BigDecimal calculate = provider.calculate(new BigDecimal("1000.00"));
        assertEquals(calculate, new BigDecimal("130.00"));
    }

    @DataProvider
    public Object[][] taxCalculatorDataProvider() {
        return new Object[][] {
            {new RuTaxCalculator(), new BigDecimal("1000.00"), new BigDecimal("130.00")},
            {new TuTaxCalculator(), new BigDecimal("999.99"), new BigDecimal("99.99")},
            {new TuTaxCalculator(), new BigDecimal("1001.00"), new BigDecimal("240.24")},
            {new TuTaxCalculator(), new BigDecimal("3001.00"), new BigDecimal("1050.35")}
        };
    }

    @Test(dataProvider = "taxCalculatorDataProvider")
    public void taxCalculatorTest(TaxCalculator calculator, BigDecimal income, BigDecimal expectedTax) {
        TaxCalculatorProvider provider = new TaxCalculatorProviderImpl(calculator);
        BigDecimal calculate = provider.calculate(income);
        assertEquals(calculate, expectedTax);
    }
}
