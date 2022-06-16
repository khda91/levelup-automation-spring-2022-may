package ru.levelp.at.lesson0507.selenium.page.objects.composite.component;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class OzonBaseComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected OzonBaseComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void fillInputField(final WebElement inputField, final String text) {
        wait.until(ExpectedConditions.visibilityOf(inputField)).sendKeys(text);
    }
}
