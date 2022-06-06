package ru.levelp.at.lesson0507.selenium.locators;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumCssSelectorLocatorExampleTest extends AbstractSeleniumLocatorExampleTest {

    @Test
    public void idCssSelectorLocatorTest() {
        // WebElement applicationButton = driver.findElement(By.id("gbwa")); DOM Locator
        WebElement applicationButton = driver.findElement(By.cssSelector("#gbwa"));
        applicationButton.click();
        SleepUtils.sleep(1500);

        // WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']")); XPath
        WebElement applicationFrame = driver
            .findElement(By.cssSelector("div > iframe[role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        SleepUtils.sleep(1000);
        List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    @Test
    public void nameCssSelectorLocatorTest() {
        // WebElement searchTextBox = driver.findElement(By.name("q")); DOMLocator
        WebElement searchTextBox = driver.findElement(By.cssSelector("[name='q']"));
        searchTextBox.sendKeys("яндекс" + Keys.ENTER);

        //        WebElement searchButton = driver.findElement(By.name("btnK"));
        //        searchButton.click();
        SleepUtils.sleep(2000);

        // assertTrue(driver.findElement(By.id("search")).isDisplayed()); DOM Locator
        // assertTrue(driver.findElement(By.cssSelector("#search")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[id='search']")).isDisplayed());
    }

    @Test
    public void classNameCssSelectorLocatorTest() {
        // WebElement applicationButton = driver.findElement(By.className("gb_fd")); DOM Locator
        // WebElement applicationButton = driver.findElement(By.cssSelector("[class='gb_fd']"));
        WebElement applicationButton = driver.findElement(By.cssSelector(".gb_fd"));
        applicationButton.click();
        SleepUtils.sleep(1500);

        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        SleepUtils.sleep(1000);
        List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }
}
