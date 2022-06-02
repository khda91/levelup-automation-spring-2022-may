package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ExternalDataProvider {

    public static Stream<Arguments> addDataProvider() {
        return Stream.of(
            Arguments.of(2, 2, 4),
            Arguments.of(3, 4, 7),
            Arguments.of(8, 9, 17)
        );
    }

    public static Stream<Arguments> divideDataProvider() {
        return Stream.of(
            Arguments.of(2, 2, 1),
            Arguments.of(8, 4, 2),
            Arguments.of(32, 16, 2)
        );
    }

    public static Stream<Arguments> powerDataProvider() {
        Object[][] array = new Object[][] {
            {2, 2, 4},
            {3, 4, 81},
            {2, 10, 1024}
        };

        Random rnd = new SecureRandom();
        int randomRow = rnd.nextInt(array.length);
        return Stream.of(
            Arguments.of(array[randomRow][0], array[randomRow][1], array[randomRow][2])
        );
    }
}
