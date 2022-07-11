package ru.levelp.at.lesson12.design.patterns.factory.method;

import java.util.Locale;
import org.openqa.selenium.WebDriver;

public final class WebDriverProvider {

    private static WebDriver driver;

    private WebDriverProvider() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserName = System.getProperty("browser.name");
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
