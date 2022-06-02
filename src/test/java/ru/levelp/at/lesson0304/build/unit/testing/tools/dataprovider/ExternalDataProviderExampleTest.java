package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ExternalDataProviderExampleTest extends BaseDataProviderTest {

    @Test(dataProvider = "addDataProvider", dataProviderClass = ExternalDataProvider.class)
    public void addTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "addTest"));
        int res = calculator.add(a, b);
        assertEquals(res, expectedResult);
    }

    @Test(dataProvider = "Test Data for Divide Method Test", dataProviderClass = ExternalDataProvider.class)
    public void divideTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "divideTest"));
        int res = calculator.divide(a, b);
        assertEquals(res, expectedResult);
    }

    @Test(dataProvider = "powerDataProvider", dataProviderClass = ExternalDataProvider.class)
    public void powerTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "powerTest"));
        int res = calculator.power(a, b);
        assertEquals(res, expectedResult);
    }
}
