package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

public class CalculatorBeforeAfterMethodHookIT extends BaseCalculatorBeforeAfterHooksIT {

    @BeforeEach
    @Override
    public void setUp() {
        System.out.println("^_^ ^_^ ^_^");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "setUp"));
        calculator = new Calculator();
        System.out.println("this method was override");
    }

    @Test
    public void testAdd2And2() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "testAdd2And2"));
        int res = calculator.add(2, 2);
        assertEquals(4, res);
    }

    @Test
    public void testAdd2Point0And4Point0() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "testAdd2Point0And4Point0"));
        double res = calculator.add(2.0D, 4.0D);
        assertEquals(6.0D, res);
    }

    @AfterAll
    @Override
    public void afterClass() {
        System.out.println("XD XD XD");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "afterClass"));
        calculator = new Calculator();
        System.out.println("this method was override");
    }
}
