package ru.levelp.at.lesson0507.selenium.locators;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumXPathLocatorExampleTest extends AbstractSeleniumLocatorExampleTest {

    @Test
    public void idXPathLocatorTest() {
        // WebElement applicationButton = driver.findElement(By.id("gbwa")); DOM Locator
        // WebElement applicationButton = driver.findElement(By.cssSelector("#gbwa")); CSS Selector
        // WebElement applicationButton = driver.findElement(By.xpath("//div[@id='gbwa']"));
        WebElement applicationButton = driver.findElement(By.xpath("//*[@id='gbwa']"));
        applicationButton.click();
        SleepUtils.sleep(1500);

        //        WebElement applicationFrame = driver
        //            .findElement(By.cssSelector("div > iframe[role='presentation']")); xpath
        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        SleepUtils.sleep(1000);
        // List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li")); css selector
        List<WebElement> applicationElements = driver.findElements(By.xpath("//ul//li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    @Test
    public void nameXPathLocatorTest() {
        // WebElement searchTextBox = driver.findElement(By.name("q")); DOMLocator
        // WebElement searchTextBox = driver.findElement(By.cssSelector("[name='q']")); css selector
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchTextBox.sendKeys("яндекс" + Keys.ENTER);

        //        WebElement searchButton = driver.findElement(By.name("btnK"));
        //        searchButton.click();
        SleepUtils.sleep(2000);

        // assertTrue(driver.findElement(By.id("search")).isDisplayed()); DOM Locator
        // assertTrue(driver.findElement(By.cssSelector("#search")).isDisplayed());
        // assertTrue(driver.findElement(By.cssSelector("[id='search']")).isDisplayed()); css selector
        assertTrue(driver.findElement(By.xpath("//*[@id='search']")).isDisplayed());
    }

    @Test
    public void classNameXPathLocatorTest() {
        // WebElement applicationButton = driver.findElement(By.className("gb_fd")); DOM Locator
        // WebElement applicationButton = driver.findElement(By.cssSelector("[class='gb_fd']"));
        // WebElement applicationButton = driver.findElement(By.cssSelector(".gb_fd")); CSS selector
        WebElement applicationButton = driver.findElement(By.xpath("//*[contains(@class, 'gb_fd')]"));
        applicationButton.click();
        SleepUtils.sleep(1500);

        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        SleepUtils.sleep(1000);
        List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    @Test
    public void linkTextXPathLocatorTest() {
        // WebElement gmailLink = driver.findElement(By.linkText("Gmail")); DOM Locator
        WebElement gmailLink = driver.findElement(By.xpath("//*[text()='Gmail']"));
        gmailLink.click();
        SleepUtils.sleep(2000);

        assertTrue(driver.getTitle().contains("Gmail"));
    }

    @Test
    public void partialLinkTextXPathLocatorTest() {
        // WebElement gmailLink = driver.findElement(By.partialLinkText("Imag"));
        WebElement gmailLink = driver.findElement(By.xpath("//*[contains(text(), 'Imag')]"));
        gmailLink.click();
        SleepUtils.sleep(2000);

        assertTrue(driver.getCurrentUrl().contains("imghp"));
    }

    @Test
    public void indexesXPathLocatorTest() {
        // WebElement applicationButton = driver.findElement(By.id("gbwa")); DOM Locator
        // WebElement applicationButton = driver.findElement(By.cssSelector("#gbwa")); CSS Selector
        // WebElement applicationButton = driver.findElement(By.xpath("//div[@id='gbwa']"));
        WebElement applicationButton = driver.findElement(By.xpath("//*[@id='gbwa']"));
        applicationButton.click();
        SleepUtils.sleep(1500);

        //        WebElement applicationFrame = driver
        //            .findElement(By.cssSelector("div > iframe[role='presentation']")); xpath
        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        SleepUtils.sleep(1000);
        // List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li")); css selector
        WebElement applicationElement = driver.findElement(By.xpath("//ul//li[5]"));
        System.out.println(String.format("Text from application element [5]: %s", applicationElement.getText()));
    }
}
