package ru.levelp.at.lesson1011.cicd.ui.step;

import static org.testng.Assert.assertEquals;

import io.qameta.allure.Step;
import java.util.Locale;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.cicd.ui.UsersBugRedLoginRegistrationPage;
import ru.levelp.at.lesson1011.cicd.ui.UsersBugRedUsersPage;

public class UserBugRedSteps {

    private WebDriver driver;

    private UsersBugRedLoginRegistrationPage loginRegistrationPage;
    private UsersBugRedUsersPage usersPage;

    public UserBugRedSteps(WebDriver driver) {
        this.driver = driver;
        this.loginRegistrationPage = new UsersBugRedLoginRegistrationPage(driver);
        this.usersPage = new UsersBugRedUsersPage(driver);
    }

    @Step("Открываем сайт")
    public void openUserBugRedApplication() {
        loginRegistrationPage.open();
    }

    @Step("Регистрирую пользователя: '{0}' с email: '{1}' и паролем: '{2}'")
    public void registrationInApplication(final String username, final String email, final String password) {
        loginRegistrationPage.fillUsernameInputField(username);
        loginRegistrationPage.fillEmailInputField(email);
        loginRegistrationPage.fillPasswordInputField(password);
        loginRegistrationPage.clickRegisterButton();
    }

    @Step("Регистрирую пользователя: '{username}' с email: '{email}' и паролем: '{password}'")
    public void registrationInApplicationWithParamNames(final String username,
                                                        final String email, final String password) {
        loginRegistrationPage.fillUsernameInputField(username);
        loginRegistrationPage.fillEmailInputField(email);
        loginRegistrationPage.fillPasswordInputField(password);
        loginRegistrationPage.clickRegisterButton();
    }

    @Step("Проверяем, что имя пользователя совпадает с {expectedUsername}")
    public void assertThatLoginUsernameEqualsToExpected(final String expectedUsername) {
        assertEquals(usersPage.getUsernameFromDropdown().toLowerCase(Locale.ROOT),
            expectedUsername.toLowerCase(Locale.ROOT));
    }

    @Step("Проверяем, что текст ошибки совпадает с {expectedErrorText}")
    public void assertThatErrorTextEqualsExpected(final String expectedErrorText) {
        assertEquals(loginRegistrationPage.getErrorTextLabelText(), expectedErrorText);
    }
}
