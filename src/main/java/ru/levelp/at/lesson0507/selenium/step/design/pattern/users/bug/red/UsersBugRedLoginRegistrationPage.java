package ru.levelp.at.lesson0507.selenium.step.design.pattern.users.bug.red;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsersBugRedLoginRegistrationPage extends UsersBugRedBasePage {

    private static final String USERS_BUGRED_LOGIN_REG_PAGE_URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='name']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='password']")
    private WebElement passwordInputField;

    // @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='act_register_now']")
    @FindBy(how = How.XPATH, using = "//form[contains(@action, 'register')]//*[@name='act_register_now']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[contains(@action, 'register')]/p")
    private WebElement errorTextLabel;

    public UsersBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open(USERS_BUGRED_LOGIN_REG_PAGE_URL);
    }

    public void fillUsernameInputField(final String username) {
        fillInputField(usernameInputField, username);
    }

    public void fillEmailInputField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInputField)).sendKeys(email);
    }

    public void fillPasswordInputField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInputField)).sendKeys(password);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public String getErrorTextLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(errorTextLabel)).getText();
    }
}
