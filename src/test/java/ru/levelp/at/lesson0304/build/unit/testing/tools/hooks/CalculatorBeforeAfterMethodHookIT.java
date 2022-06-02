package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

class CalculatorBeforeAfterMethodHookIT {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        System.out.println("=====");
        System.out.println(String.format("Class: %s, method %s", CalculatorBeforeAfterMethodHookIT.class
            .getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @Test
    void testAdd2And2() {
        System.out.println(String.format("Class: %s, test method %s", CalculatorBeforeAfterMethodHookIT.class
            .getCanonicalName(), "testAdd2And2"));
        int res = calculator.add(2, 2);
        assertEquals(4, res);
    }

    @Test
    void testAdd2Point0And4Point0() {
        System.out.println(String.format("Class: %s, test method %s", CalculatorBeforeAfterMethodHookIT.class
            .getCanonicalName(), "testAdd2Point0And4Point0"));
        double res = calculator.add(2.0D, 4.0D);
        assertEquals(6.0D, res);
    }

    @AfterEach
    public void tearDown() {
        System.out.println(String.format("Class: %s, method %s", CalculatorBeforeAfterMethodHookIT.class
            .getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=====");
        System.out.println();
    }
}
