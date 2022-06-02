package ru.levelp.at.lesson0304.build.unit.testing.tools.simple;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

class CalculatorSimpleIT {

    @Test
    void testAdd2And2() {
        Calculator calculator = new Calculator();
        int res = calculator.add(2, 2);
        assertEquals(4, res);
    }

    @Test
    void testAdd2Point0And4Point0() {
        Calculator calculator = new Calculator();
        double res = calculator.add(2.0D, 4.0D);
        assertEquals(6.0D, res);
    }
}
