package ru.level.at.taf.skeleton.trello.service.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTrelloPage extends AbstractTrelloBasePage {

    private static final String LOGIN_PAGE_URL = "/login";

    @FindBy(xpath = "//div[@class='email-password']//input[@id='user']")
    private WebElement emailTextField;

    @FindBy(xpath = "//div[@class='email-password']//input[@id='password']")
    private WebElement passwordTextField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginTrelloPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open(LOGIN_PAGE_URL);
    }

    public void fillUsernameTextField(final String username) {
        wait.until(ExpectedConditions.visibilityOf(emailTextField)).sendKeys(username);
    }

    public void fillPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
