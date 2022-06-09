package ru.levelp.at.lesson0507.selenium.basic.waits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWaitExplicitVsImplicitExampleTest extends AbstractSeleniumWaitTest {

    private WebDriverWait wait;

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
    }

    // implicit wait = 10 sec
    // explicit wait = 7 sec
    @Test
    public void googleSearchTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        WebElement searchTextBox = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='q']")));
        searchTextBox.sendKeys(SEARCH_STRING + Keys.ENTER);

        // driver.findElements(By.cssSelector("div#search a > h3"));
        var searchResults = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.cssSelector("div#search a > h3"), EXPECTED_SEARCH_RESULT_SIZE));
        assertTrue(searchResults.size() > EXPECTED_SEARCH_RESULT_SIZE);
        assertEquals(searchResults.get(0).getText(), EXPECTED_FIRST_LINK_TITLE);
    }

    // implicit wait = 10 sec
    // explicit wait = 7 sec
    @Test
    public void googleSearchFindElementFailTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        WebElement searchTextBox = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='q1']")));
        searchTextBox.sendKeys(SEARCH_STRING + Keys.ENTER);

        // driver.findElements(By.cssSelector("div#search a > h3"));
        var searchResults = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.cssSelector("div#search a > h3"), EXPECTED_SEARCH_RESULT_SIZE));
        assertTrue(searchResults.size() > EXPECTED_SEARCH_RESULT_SIZE);
        assertEquals(searchResults.get(0).getText(), EXPECTED_FIRST_LINK_TITLE);
    }

    // implicit wait = 7 sec
    // explicit wait = 10 sec
    @Test
    public void googleSearchFindElementsFailTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchTextBox = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='q']")));
        searchTextBox.sendKeys(SEARCH_STRING + Keys.ENTER);

        // driver.findElements(By.cssSelector("div#search a > h3"));
        var searchResults = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.cssSelector("div#search1 a > h3"), EXPECTED_SEARCH_RESULT_SIZE));
        assertTrue(searchResults.isEmpty());
        assertTrue(searchResults.size() > EXPECTED_SEARCH_RESULT_SIZE);
        assertEquals(searchResults.get(0).getText(), EXPECTED_FIRST_LINK_TITLE);
    }

    // implicit wait = 7 sec
    // explicit wait = 10 sec
    @Test
    public void googleSearchExplicitAndImplicitWaitTogetherTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchTextBox = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='q']")));
        searchTextBox.sendKeys(SEARCH_STRING + Keys.ENTER);

        List<WebElement> searchResults;
        var implicitWaitTimeout = driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);

        try {
            searchResults = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.cssSelector("div#search1 a > h3"), EXPECTED_SEARCH_RESULT_SIZE));
        } finally {
            driver.manage().timeouts().implicitlyWait(implicitWaitTimeout);
        }
        assertTrue(searchResults.isEmpty());
        assertTrue(searchResults.size() > EXPECTED_SEARCH_RESULT_SIZE);
        assertEquals(searchResults.get(0).getText(), EXPECTED_FIRST_LINK_TITLE);
    }
}
