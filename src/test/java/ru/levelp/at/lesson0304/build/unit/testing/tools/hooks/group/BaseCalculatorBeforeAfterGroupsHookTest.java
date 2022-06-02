package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

public abstract class BaseCalculatorBeforeAfterGroupsHookTest {

    protected Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println("=====");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=====");
        System.out.println();
    }

    @BeforeGroups(groups = {"add"})
    public void beforeAddGroup() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "beforeAddGroup"));
        System.out.println();
    }

    @AfterGroups(groups = {"integer"})
    public void afterIntegerGroup() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(),
            "afterIntegerGroup"));
        System.out.println("*****");
        System.out.println();
    }

    @BeforeGroups(groups = {"double", "subtract"})
    public void beforeDoubleAndSubtractGroup() {
        System.out.println("-----");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(),
            "beforeDoubleAndSubtractGroup"));
        System.out.println();
    }

    @AfterGroups(groups = {"integer", "multiply"})
    public void afterIntegerAndMultiplyGroup() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(),
            "afterIntegerAndMultiplyGroup"));
        System.out.println("%%%%%");
        System.out.println();
    }
}
