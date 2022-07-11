package ru.levelp.at.lesson12.design.patterns.stategy;

import java.math.BigDecimal;
import java.util.Scanner;

public class TaxCalculatorApp {

    public static void main(String[] args) {
        System.out.print("Enter tax country: ");
        Scanner scanner = new Scanner(System.in);
        String countryCode = scanner.nextLine();
        System.out.print("Enter monthly income: ");
        String monthlyIncome = scanner.nextLine();

        TaxCalculator taxCalculator = null;
        if ("RU".equalsIgnoreCase(countryCode)) {
            taxCalculator = new RuTaxCalculator();
        } else if ("TU".equalsIgnoreCase(countryCode)) {
            taxCalculator = new TuTaxCalculator();
        }

        TaxCalculatorProvider taxCalculatorProvider = new TaxCalculatorProviderImpl(taxCalculator);
        var res = taxCalculatorProvider.calculate(new BigDecimal(monthlyIncome));
        System.out.println(String.format("%s of tax should be paid for %s country", res, countryCode));
    }
}
