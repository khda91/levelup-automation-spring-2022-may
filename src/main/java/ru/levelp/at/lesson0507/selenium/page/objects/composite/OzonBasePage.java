package ru.levelp.at.lesson0507.selenium.page.objects.composite;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.lesson0507.selenium.page.objects.composite.component.OzonHeaderComponent;

public abstract class OzonBasePage {

    private static final String OZON_URL = "https://ozon.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected OzonHeaderComponent header;

    protected OzonBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        header = new OzonHeaderComponent(driver);
    }

    public abstract void open();

    protected void open(final String relativeUrl) {
        driver.navigate().to(OZON_URL + relativeUrl);
    }

    protected void fillInputField(final WebElement inputField, final String text) {
        wait.until(ExpectedConditions.visibilityOf(inputField)).sendKeys(text);
    }

    public OzonHeaderComponent header() {
        return header;
    }
}
