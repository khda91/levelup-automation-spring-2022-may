package ru.levelp.at.lesson12.design.patterns.value.object.test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson12.design.patterns.value.object.step.UserBugRedSteps;

public abstract class AbstractSeleniumBaseTest {

    protected static final Faker FAKER = new Faker();

    // public static WebDriver driver; для передачи driver в Listener так делать НЕ НАДО
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected UserBugRedSteps steps;

    @BeforeSuite(description = "Инициализируем тестовый сьют")
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(description = "Инициализация драйвера")
    public void setUp(ITestContext context) {
        final var headless = System.getProperty("browser.headless", "false");

        driver = new ChromeDriver(new ChromeOptions()
            .setHeadless(Boolean.parseBoolean(headless)));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        steps = new UserBugRedSteps(driver);

        context.setAttribute("driver", driver);
    }

    @AfterMethod(description = "Закрытие драйвера")
    public void tearDown() {
        driver.quit();
    }
}
