package ru.level.at.taf.skeleton.trello.service.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import ru.level.at.taf.skeleton.trello.exception.UnsupportedBrowserException;

public final class WebDriverFactory {

    private WebDriverFactory() {

    }

    public static WebDriver createDriver(Browser browser) {
        switch (browser) {
            case EDGE:
                return createEdgeDriver();
            case CHROME:
                return createChromeDriver();
            case FIREFOX:
                return createFirefoxDriver();
            case OPERA:
                return createOperaDriver();
            default:
                throw new UnsupportedBrowserException();
        }
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
