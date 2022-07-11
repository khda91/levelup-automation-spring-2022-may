package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class WebDriverFactoryTest {

    @Test
    public void createChromeDriver() {
        System.setProperty("browser.name", "chrome");
        WebDriver driver = WebDriverProvider.getDriver();
        driver.navigate().to("https://ya.ru");
        SleepUtils.sleep(2500);
    }

    @Test
    public void createFirefoxDriver() {
        System.setProperty("browser.name", "FiReFox");
        WebDriver driver = WebDriverProvider.getDriver();
        driver.navigate().to("https://google.com");
        SleepUtils.sleep(2500);
    }

    @Test
    public void createEdgeDriver() {
        System.setProperty("browser.name", "EDGE");
        WebDriver driver = WebDriverProvider.getDriver();
        driver.navigate().to("https://yahoo.com");
        SleepUtils.sleep(2500);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverProvider.close();
    }
}
