package ru.levelp.at.lesson0304.build.unit.testing.tools;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int power(int num, int p) {
        if (p < 0) {
            throw new IllegalArgumentException(String.format("Value of power for %d num should be positive. "
                + "Your power value is %d", num, p));
        }

        int res = 1;
        for (int i = 0; i < p; i++) {
            res *= num;
        }
        return res;
    }

    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("nums should not be less then 0");
        } else if (num == 0) {
            return 1;
        }

        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }

        return res;
    }
}
