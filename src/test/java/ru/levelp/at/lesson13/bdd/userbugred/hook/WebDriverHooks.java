package ru.levelp.at.lesson13.bdd.userbugred.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.lesson13.bdd.userbugred.context.TestContext;

public class WebDriverHooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        TestContext.getInstance().addAttribute("driver", driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.cleanContext();
    }
}
