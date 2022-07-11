package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class WebDriverFactoryCmdTest {

    @Test
    public void createDriver() {
        WebDriver driver = WebDriverProvider.getDriver();
        driver.navigate().to("https://ya.ru");
        SleepUtils.sleep(2500);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverProvider.close();
    }
}
