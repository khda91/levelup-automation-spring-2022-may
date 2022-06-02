package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.group;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorSimpleFunctionTest extends BaseCalculatorBeforeAfterGroupsHookTest {

    @Test(groups = {"add", "integer"})
    public void addIntTest() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "addIntTest"));
        int res = calculator.add(2, 2);
        assertEquals(res, 4);
    }

    @Test(groups = {"subtract", "integer"})
    public void subtractIntTest() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "subtractIntTest"));
        int res = calculator.subtract(6, 2);
        assertEquals(res, 4);
    }

    @Test(groups = {"multiply", "integer"})
    public void multiplyIntTest() {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "multiplyIntTest"));
        int res = calculator.multiply(6, 2);
        assertEquals(res, 12);
    }
}
