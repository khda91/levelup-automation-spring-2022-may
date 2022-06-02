package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ExternalDataProviderExampleIT extends BaseDataProviderIT {

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider.ExternalDataProvider#addDataProvider")
    public void addTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "addTest"));
        int res = calculator.add(a, b);
        assertEquals(expectedResult, res);
    }

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson0304.build.unit.testing.tools"
        + ".dataprovider.ExternalDataProvider#divideDataProvider")
    public void divideTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "divideTest"));
        int res = calculator.divide(a, b);
        assertEquals(expectedResult, res);
    }

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson0304.build.unit.testing.tools"
        + ".dataprovider.ExternalDataProvider#powerDataProvider")
    public void powerTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "powerTest"));
        int res = calculator.power(a, b);
        assertEquals(expectedResult, res);
    }
}
