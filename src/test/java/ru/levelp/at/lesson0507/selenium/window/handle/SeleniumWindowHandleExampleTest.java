package ru.levelp.at.lesson0507.selenium.window.handle;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumWindowHandleExampleTest {

    private static final String GOOGLE_URL = "https://google.com";
    private static final String YA_URL = "https://ya.ru";
    private static final String YANDEX_URL = "https://yandex.ru";
    private static final String EPAM_URL = "https://epam.com";

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void openMultipleWebSitesTest() {
        // открываем google.com
        SleepUtils.sleep(1500);
        driver.navigate().to(GOOGLE_URL);
        var windowHandles = driver.getWindowHandles();
        System.out.println(String.format("After open %s window handles are %s", GOOGLE_URL, windowHandles));
        SleepUtils.sleep(2500);

        // открываем ya.ru
        driver.switchTo().newWindow(WindowType.TAB);
        SleepUtils.sleep(1500);
        driver.get(YA_URL);
        windowHandles = driver.getWindowHandles();
        var yaRuWindowHandle = driver.getWindowHandle();
        System.out.println(String.format("After open %s window handles are %s", YA_URL, windowHandles));
        SleepUtils.sleep(2500);

        // открываем yandex.ru
        driver.switchTo().newWindow(WindowType.WINDOW);
        SleepUtils.sleep(1500);
        driver.get(YANDEX_URL);
        windowHandles = driver.getWindowHandles();
        System.out.println(String.format("After open %s window handles are %s", YANDEX_URL, windowHandles));
        SleepUtils.sleep(2500);

        // закрываем yandex.ru
        driver.close();
        driver.switchTo().window(yaRuWindowHandle);
        windowHandles = driver.getWindowHandles();
        System.out.println(String.format("After close %s window handles are %s", YANDEX_URL, windowHandles));
        SleepUtils.sleep(2500);

        // открываем epam.com
        driver.switchTo().newWindow(WindowType.WINDOW);
        SleepUtils.sleep(1500);
        driver.get(EPAM_URL);
        windowHandles = driver.getWindowHandles();
        System.out.println(String.format("After open %s window handles are %s", EPAM_URL, windowHandles));
        SleepUtils.sleep(2500);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        SleepUtils.sleep(1500);
    }
}
