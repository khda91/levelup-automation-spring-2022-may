package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.inheritance;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

public abstract class BaseCalculatorBeforeAfterHooksTest {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("+++++");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "beforeSuite"));
        System.out.println();
    }

    @BeforeTest // (alwaysRun = true)
    public void beforeTest() {
        System.out.println("-----");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "beforeTest"));
        System.out.println();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "beforeClass"));
        System.out.println();
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("=====");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=====");
        System.out.println();
    }

    @AfterClass
    public void afterClass() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "afterClass"));
        System.out.println("*****");
        System.out.println();
    }

    @AfterTest //(alwaysRun = true)
    public void afterTest() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "afterTest"));
        System.out.println("-----");
        System.out.println();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "afterSuite"));
        System.out.println("+++++");
        System.out.println();
    }
}
