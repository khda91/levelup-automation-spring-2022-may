package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class InternalDataProviderExampleIT extends BaseDataProviderIT {

    @ParameterizedTest
    @CsvSource({
        "2, 2, 4",
        "3, 4, 7",
        "8, 9, 17"
    })
    void addTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "addTest"));
        int res = calculator.add(a, b);
        assertEquals(expectedResult, res);
    }

    static Stream<Arguments> divideDataProvider() {
        return Stream.of(
            Arguments.of(2, 2, 1),
            Arguments.of(8, 4, 2),
            Arguments.of(32, 16, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("divideDataProvider")
    public void divideTest(int a, int b, int expectedResult) {
        System.out.println(String.format("Class: %s, test method %s", this.getClass().getCanonicalName(),
            "divideTest"));
        int res = calculator.divide(a, b);
        assertEquals(res, expectedResult);
    }
}
