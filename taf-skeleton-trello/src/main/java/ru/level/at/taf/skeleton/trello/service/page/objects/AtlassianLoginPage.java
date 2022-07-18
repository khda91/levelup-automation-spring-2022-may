package ru.level.at.taf.skeleton.trello.service.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AtlassianLoginPage extends AbstractTrelloBasePage {

    @FindBy(xpath = "//form[@id='form-login']//*[@id='password']")
    private WebElement passwordTextField;

    @FindBy(id = "login-submit")
    private WebElement loginButton;

    public AtlassianLoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Override
    public void open() {
        // emtpy method
    }
}
