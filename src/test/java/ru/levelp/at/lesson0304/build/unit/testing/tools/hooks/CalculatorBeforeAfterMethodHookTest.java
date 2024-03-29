package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

public class CalculatorBeforeAfterMethodHookTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("=====");
        System.out.println(String.format("Class: %s, method %s", CalculatorBeforeAfterMethodHookTest.class
            .getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @Test
    public void testAdd2And2() {
        System.out.println(String.format("Class: %s, test method %s", CalculatorBeforeAfterMethodHookTest.class
            .getCanonicalName(), "testAdd2And2"));
        int res = calculator.add(2, 2);
        assertEquals(res, 4);
    }

    @Test
    public void testAdd2Point0And4Point0() {
        System.out.println(String.format("Class: %s, test method %s", CalculatorBeforeAfterMethodHookTest.class
            .getCanonicalName(), "testAdd2Point0And4Point0"));
        double res = calculator.add(2.0D, 4.0D);
        assertEquals(res, 6.0D);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(String.format("Class: %s, method %s", CalculatorBeforeAfterMethodHookTest.class
            .getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=====");
        System.out.println();
    }
}
