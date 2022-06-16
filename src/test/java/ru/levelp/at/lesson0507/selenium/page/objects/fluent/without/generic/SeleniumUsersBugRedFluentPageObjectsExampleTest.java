package ru.levelp.at.lesson0507.selenium.page.objects.fluent.without.generic;

import static org.testng.Assert.assertEquals;

import java.util.Locale;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.AbstractSeleniumBaseTest;

public class SeleniumUsersBugRedFluentPageObjectsExampleTest extends AbstractSeleniumBaseTest {

    @Test
    public void registerUserTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var usersPage = new UsersBugRedLoginRegistrationPage(driver)
            .open()
            .fillUsernameInputField(username)
            .fillEmailInputField(email)
            .fillPasswordInputField(password)
            .clickRegisterButton();

        var userMenuDropdown = usersPage.getUsernameFromDropdown();
        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }

    @Test
    public void registerUserFluentTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var userMenuDropdown = new UsersBugRedLoginRegistrationPage(driver)
            .open()
            .fillUsernameInputField(username)
            .fillEmailInputField(email)
            .fillPasswordInputField(password)
            .successClickRegisterButton()
            .getUsernameFromDropdown();

        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }

    @Test
    public void registerUserWithInvalidEmailTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.name().username();
        var password = FAKER.internet().password();

        var actualErrorText = new UsersBugRedLoginRegistrationPage(driver)
            .open()
            .fillUsernameInputField(username)
            .fillEmailInputField(email)
            .fillPasswordInputField(password)
            .failedClickRegisterButton()
            .getErrorTextLabelText();

        assertEquals(actualErrorText, "register_not_correct_field (email)");
    }

    @Test
    public void registerUserFluentWithReturnCommonTypeTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var userMenuDropdown = ((UsersBugRedUsersPage) new UsersBugRedLoginRegistrationPage(driver)
            .open()
            .fillUsernameInputField(username)
            .fillEmailInputField(email)
            .fillPasswordInputField(password)
            .clickWithReturnCommonType())
            .getUsernameFromDropdown();

        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }

    @Test
    public void registerUserWithInvalidEmailAndReturnCommonTypeTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.name().username();
        var password = FAKER.internet().password();

        var actualErrorText = ((UsersBugRedLoginRegistrationPage) new UsersBugRedLoginRegistrationPage(driver)
            .open()
            .fillUsernameInputField(username)
            .fillEmailInputField(email)
            .fillPasswordInputField(password)
            .clickWithReturnCommonType())
            .getErrorTextLabelText();

        assertEquals(actualErrorText, "register_not_correct_field (email)");
    }


}
