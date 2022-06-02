package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorBeforeAfterSuiteHookIT extends BaseCalculatorBeforeAfterHooksIT {

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
}
