package ru.level.at.taf.skeleton.trello.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.level.at.taf.skeleton.trello.service.driver.WebDriverProvider;

public abstract class AbstractTrelloBaseTest {

    @BeforeEach
    void initWebDriver() {
        WebDriverProvider.getDriver();
    }

    @AfterEach
    void tearDown() {
        WebDriverProvider.close();
    }
}
