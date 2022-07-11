package ru.levelp.at.lesson12.design.patterns.factory.method.exception;

import java.util.Arrays;
import java.util.stream.Collectors;
import ru.levelp.at.lesson12.design.patterns.factory.method.Browser;

public class UnsupportedBrowserException extends RuntimeException {

    public UnsupportedBrowserException() {
        super("Unsupported browser was chosen. Supported browsers are: "
            + Arrays.stream(Browser.values())
                    .map(Enum::toString)
                    .collect(Collectors.joining(",")));
    }
}
