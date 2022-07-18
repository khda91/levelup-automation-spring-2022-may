package ru.level.at.taf.skeleton.trello.service.driver;

import java.util.Locale;
import org.openqa.selenium.WebDriver;

public final class WebDriverProvider {

    private static WebDriver driver;

    private WebDriverProvider() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserName = System.getProperty("browser.name", "chrome");
            Browser browser = Browser.valueOf(browserName.toUpperCase(Locale.ROOT));
            driver = WebDriverFactory.createDriver(browser);
        }
        return driver;
    }

    public static void close() {
        driver.quit();
        driver = null;
    }
}
