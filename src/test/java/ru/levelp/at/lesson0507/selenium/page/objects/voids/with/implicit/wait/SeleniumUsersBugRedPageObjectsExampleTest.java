package ru.levelp.at.lesson0507.selenium.page.objects.voids.with.implicit.wait;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Locale;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.AbstractSeleniumBaseTest;

public class SeleniumUsersBugRedPageObjectsExampleTest extends AbstractSeleniumBaseTest {

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void registerUserTest() {
        UsersBugRedLoginRegistrationPage registrationPage = new UsersBugRedLoginRegistrationPage(driver);
        registrationPage.open();

        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        registrationPage.fillUsernameInputField(username);
        registrationPage.fillEmailInputField(email);
        registrationPage.fillPasswordInputField(password);
        registrationPage.clickRegisterButton();

        UsersBugRedUsersPage usersPage = new UsersBugRedUsersPage(driver);
        var userMenuDropdown = usersPage.getUsernameFromDropdown();
        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }
}
