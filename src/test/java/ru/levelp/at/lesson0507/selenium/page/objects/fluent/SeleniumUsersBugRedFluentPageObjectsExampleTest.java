package ru.levelp.at.lesson0507.selenium.page.objects.fluent;

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
            .clickRegisterButton()
            .getUsernameFromDropdown();

        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }
}
