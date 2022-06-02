package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.inheritance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class BaseCalculatorBeforeAfterHooksIT {

    protected Calculator calculator;

    @BeforeAll
    public void beforeClass() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "beforeClass"));
        System.out.println();
    }

    @BeforeEach
    public void setUp() {
        System.out.println("=====");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=====");
        System.out.println();
    }

    @AfterAll
    public void afterClass() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "afterClass"));
        System.out.println("*****");
        System.out.println();
    }
}
