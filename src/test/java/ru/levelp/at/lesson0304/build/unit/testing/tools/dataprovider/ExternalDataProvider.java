package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import java.security.SecureRandom;
import java.util.Random;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.DataProvider;

public class ExternalDataProvider {

    @DataProvider
    public static Object[][] addDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {3, 4, 7},
            {8, 9, 17}
        };
    }

    @DataProvider(name = "Test Data for Divide Method Test")
    public static Object[][] divideDataProvider() {
        return new Object[][] {
            {2, 2, 1},
            {8, 4, 2},
            {32, 16, 2}
        };
    }

    @DataProvider
    public static Object[][] powerDataProvider() {
        Object[][] array = new Object[][] {
            {2, 2, 4},
            {3, 4, 81},
            {2, 10, 1024}
        };

        Random rnd = new SecureRandom();
        int randomRow = rnd.nextInt(array.length);
        return new Object[][] {
            array[randomRow]
        };
    }
}
