package ru.levelp.at.lesson1011.cicd.ui;

import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UsersBugRedBasePage {

    private static final String USERS_BUGRED_URL = "http://users.bugred.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected UsersBugRedBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public abstract void open();

    protected void open(final String relativeUrl) {
        driver.navigate().to(USERS_BUGRED_URL + relativeUrl);
    }

    @Step("Send keys '{text}' to {inputField}")
    protected void fillInputField(final WebElement inputField, final String text) {
        wait.until(ExpectedConditions.visibilityOf(inputField)).sendKeys(text);
    }
}
