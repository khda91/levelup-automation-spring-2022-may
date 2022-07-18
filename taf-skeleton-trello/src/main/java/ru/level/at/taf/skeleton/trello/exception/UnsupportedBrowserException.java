package ru.level.at.taf.skeleton.trello.exception;

import java.util.Arrays;
import java.util.stream.Collectors;
import ru.level.at.taf.skeleton.trello.service.driver.Browser;

public class UnsupportedBrowserException extends RuntimeException {

    public UnsupportedBrowserException() {
        super("Unsupported browser was chosen. Supported browsers are: "
            + Arrays.stream(Browser.values())
                    .map(Enum::toString)
                    .collect(Collectors.joining(",")));
    }
}
