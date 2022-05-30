package ru.levelp.at.lesson0304.build.unit.testing.tools.simple;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

public class CalculatorSimpleTest {

    @Test
    public void testAdd2And2() {
        Calculator calculator = new Calculator();
        int res = calculator.add(2, 2);
        assertEquals(res, 4);
    }

    @Test
    public void testAdd2Point0And4Point0() {
        Calculator calculator = new Calculator();
        double res = calculator.add(2.0D, 4.0D);
        assertEquals(res, 6.0D);
    }
}
