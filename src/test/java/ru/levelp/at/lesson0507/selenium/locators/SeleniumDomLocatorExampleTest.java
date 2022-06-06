package ru.levelp.at.lesson0507.selenium.locators;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumDomLocatorExampleTest extends AbstractSeleniumLocatorExampleTest {

    @Test
    public void idDomLocatorTest() {
        WebElement applicationButton = driver.findElement(By.id("gbwa"));
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
    public void nameDomLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("яндекс" + Keys.ENTER);

        //        WebElement searchButton = driver.findElement(By.name("btnK"));
        //        searchButton.click();
        SleepUtils.sleep(2000);

        assertTrue(driver.findElement(By.id("search")).isDisplayed());
    }

    @Test
    public void classNameDomLocatorTest() {
        WebElement applicationButton = driver.findElement(By.className("gb_fd"));
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
    public void linkTextDomLocatorTest() {
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();
        SleepUtils.sleep(2000);

        assertTrue(driver.getTitle().contains("Gmail"));
    }

    @Test
    public void partialLinkTextDomLocatorTest() {
        WebElement gmailLink = driver.findElement(By.partialLinkText("Imag"));
        gmailLink.click();
        SleepUtils.sleep(2000);

        assertTrue(driver.getCurrentUrl().contains("imghp"));
    }
}
