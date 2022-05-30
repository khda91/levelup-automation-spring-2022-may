package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.inheritance;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorBeforeAfterClassHookTest extends BaseCalculatorBeforeAfterHooksTest {

    @Test
    public void testAdd2And2() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "testAdd2And2"));
        int res = calculator.add(2, 2);
        assertEquals(res, 4);
    }

    @Test
    public void testAdd2Point0And4Point0() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "testAdd2Point0And4Point0"));
        double res = calculator.add(2.0D, 4.0D);
        assertEquals(res, 6.0D);
    }
}
