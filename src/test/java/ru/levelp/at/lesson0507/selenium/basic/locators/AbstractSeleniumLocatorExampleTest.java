package ru.levelp.at.lesson0507.selenium.basic.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.utils.SleepUtils;

public abstract class AbstractSeleniumLocatorExampleTest {

    private static final String GOOGLE_URL = "https://google.com";

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
        SleepUtils.sleep(750);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
