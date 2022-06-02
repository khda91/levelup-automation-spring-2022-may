package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InternalDataProviderExampleTest extends BaseDataProviderTest {

    @DataProvider
    public Object[][] addDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {3, 4, 7},
            {8, 9, 17}
        };
    }

    @Test(dataProvider = "addDataProvider")
    public void addTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "addTest"));
        int res = calculator.add(a, b);
        assertEquals(res, expectedResult);
    }

    @DataProvider(name = "Test Data for Divide Method Test")
    public Object[][] divideDataProvider() {
        return new Object[][] {
            {2, 2, 1},
            {8, 4, 2},
            {32, 16, 2}
        };
    }

    @Test(dataProvider = "Test Data for Divide Method Test")
    public void divideTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "divideTest"));
        int res = calculator.divide(a, b);
        assertEquals(res, expectedResult);
    }
}
