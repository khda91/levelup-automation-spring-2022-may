package ru.level.at.taf.skeleton.trello.step;

import org.openqa.selenium.WebDriver;
import ru.level.at.taf.skeleton.trello.service.driver.WebDriverProvider;

public abstract class AbstractBaseStep {

    protected WebDriver driver;

    protected AbstractBaseStep() {
        driver = WebDriverProvider.getDriver();
    }
}
