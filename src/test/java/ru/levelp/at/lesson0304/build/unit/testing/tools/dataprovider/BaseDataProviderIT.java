package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.lesson0304.build.unit.testing.tools.Calculator;

public abstract class BaseDataProviderIT {

    protected Calculator calculator;

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
}
