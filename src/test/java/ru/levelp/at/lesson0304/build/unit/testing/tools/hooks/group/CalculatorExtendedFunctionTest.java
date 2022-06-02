package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.group;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorExtendedFunctionTest extends BaseCalculatorBeforeAfterGroupsHookTest {

    @Test(groups = {"add", "double"})
    public void addDoubleTest() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "addDoubleTest"));
        double res = calculator.add(2D, 2D);
        assertEquals(res, 4D);
    }

    @Test(groups = {"subtract", "double"})
    public void subtractDoubleTest() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "subtractDoubleTest"));
        double res = calculator.subtract(6D, 2D);
        assertEquals(res, 4D);
    }

    @Test(groups = {"multiply", "double"})
    public void multiplyDoubleTest() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "multiplyDoubleTest"));
        double res = calculator.multiply(6D, 2D);
        assertEquals(res, 12D);
    }
}
