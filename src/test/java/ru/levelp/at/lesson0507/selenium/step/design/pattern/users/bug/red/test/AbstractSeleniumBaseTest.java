package ru.levelp.at.lesson0507.selenium.step.design.pattern.users.bug.red.test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson0507.selenium.step.design.pattern.users.bug.red.step.UserBugRedSteps;

public abstract class AbstractSeleniumBaseTest {

    protected static final Faker FAKER = new Faker();

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected UserBugRedSteps steps;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        steps = new UserBugRedSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
