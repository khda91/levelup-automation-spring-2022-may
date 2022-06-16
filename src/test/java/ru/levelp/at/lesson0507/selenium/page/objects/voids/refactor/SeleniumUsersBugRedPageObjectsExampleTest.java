package ru.levelp.at.lesson0507.selenium.page.objects.voids.refactor;

import static org.testng.Assert.assertEquals;

import java.util.Locale;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.AbstractSeleniumBaseTest;

public class SeleniumUsersBugRedPageObjectsExampleTest extends AbstractSeleniumBaseTest {

    @Test
    public void registerUserTest() {
        UsersBugRedUsersPage usersPage = new UsersBugRedUsersPage(driver);
        UsersBugRedLoginRegistrationPage registrationPage = new UsersBugRedLoginRegistrationPage(driver);

        registrationPage.open();

        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        registrationPage.fillUsernameInputField(username);
        registrationPage.fillEmailInputField(email);
        registrationPage.fillPasswordInputField(password);
        registrationPage.clickRegisterButton();

        var userMenuDropdown = usersPage.getUsernameFromDropdown();
        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }

    @Test
    public void registerUserWithInvalidEmailTest() {
        UsersBugRedLoginRegistrationPage registrationPage = new UsersBugRedLoginRegistrationPage(driver);

        registrationPage.open();

        var username = FAKER.name().fullName();
        var email = FAKER.name().username();
        var password = FAKER.internet().password();

        registrationPage.fillUsernameInputField(username);
        registrationPage.fillEmailInputField(email);
        registrationPage.fillPasswordInputField(password);
        registrationPage.clickRegisterButton();

        var actualErrorText = registrationPage.getErrorTextLabelText();
        assertEquals(actualErrorText, "register_not_correct_field (email)");
    }
}
