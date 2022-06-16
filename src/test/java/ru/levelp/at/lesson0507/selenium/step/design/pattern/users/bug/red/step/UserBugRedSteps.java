package ru.levelp.at.lesson0507.selenium.step.design.pattern.users.bug.red.step;

import static org.testng.Assert.assertEquals;

import java.util.Locale;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.selenium.step.design.pattern.users.bug.red.UsersBugRedLoginRegistrationPage;
import ru.levelp.at.lesson0507.selenium.step.design.pattern.users.bug.red.UsersBugRedUsersPage;

public class UserBugRedSteps {

    private WebDriver driver;

    private UsersBugRedLoginRegistrationPage loginRegistrationPage;
    private UsersBugRedUsersPage usersPage;

    public UserBugRedSteps(WebDriver driver) {
        this.driver = driver;
        this.loginRegistrationPage = new UsersBugRedLoginRegistrationPage(driver);
        this.usersPage = new UsersBugRedUsersPage(driver);
    }

    public void openUserBugRedApplication() {
        loginRegistrationPage.open();
    }

    public void loginInApplication(final String username, final String email, final String password) {
        loginRegistrationPage.fillUsernameInputField(username);
        loginRegistrationPage.fillEmailInputField(email);
        loginRegistrationPage.fillPasswordInputField(password);
        loginRegistrationPage.clickRegisterButton();
    }

    public void assertThatLoginUsernameEqualsToExpected(final String expectedUsername) {
        assertEquals(usersPage.getUsernameFromDropdown().toLowerCase(Locale.ROOT),
            expectedUsername.toLowerCase(Locale.ROOT));
    }

    public void assertThatErrorTextEqualsExpected(final String expectedErrorText) {
        assertEquals(loginRegistrationPage.getErrorTextLabelText(), expectedErrorText);
    }
}
