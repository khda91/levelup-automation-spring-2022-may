package ru.levelp.at.lesson0507.selenium.page.objects.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsersBugRedLoginRegistrationPage extends UsersBugRedBasePage<UsersBugRedLoginRegistrationPage> {

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

    public UsersBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public UsersBugRedLoginRegistrationPage open() {
        open(USERS_BUGRED_LOGIN_REG_PAGE_URL);
        return this;
    }

    public UsersBugRedLoginRegistrationPage fillUsernameInputField(final String username) {
        fillInputField(usernameInputField, username);
        return this;
    }

    public UsersBugRedLoginRegistrationPage fillEmailInputField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInputField)).sendKeys(email);
        return this;
    }

    public UsersBugRedLoginRegistrationPage fillPasswordInputField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInputField)).sendKeys(password);
        return this;
    }

    public UsersBugRedUsersPage clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return new UsersBugRedUsersPage(driver);
    }
}
