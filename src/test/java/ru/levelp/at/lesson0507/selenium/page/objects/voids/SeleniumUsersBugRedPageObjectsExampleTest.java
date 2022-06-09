package ru.levelp.at.lesson0507.selenium.page.objects.voids;

import static org.testng.Assert.assertEquals;

import java.util.Locale;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.AbstractSeleniumBaseTest;

public class SeleniumUsersBugRedPageObjectsExampleTest extends AbstractSeleniumBaseTest {

    @Test
    public void registerUserTest() {
        UsersBugRedLoginRegistrationPage registrationPage = new UsersBugRedLoginRegistrationPage(driver);
        // driver.navigate().to(USERS_BUGRED_LOGIN_REG_PAGE_URL);
        registrationPage.open();

        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        // var nameInputField = wait.until(ExpectedConditions
        //     .visibilityOfElementLocated(xpath("//form[contains(@action, 'register')]//*[@name='name']")));
        // nameInputField.sendKeys(username);
        registrationPage.fillUsernameInputField(username);

        // var emailInputField = wait.until(ExpectedConditions
        //    .visibilityOfElementLocated(xpath("//form[contains(@action, 'register')]//*[@name='email']")));
        // emailInputField.sendKeys(email);
        registrationPage.fillEmailInputField(email);

        // var passwordInputField = wait.until(ExpectedConditions
        //    .visibilityOfElementLocated(xpath("//form[contains(@action, 'register')]//*[@name='password']")));
        // passwordInputField.sendKeys(password);
        registrationPage.fillPasswordInputField(password);

        // var registerButton = wait.until(ExpectedConditions
        //    .elementToBeClickable(xpath("//form[contains(@action, 'register')]//*[@name='act_register_now']")));
        // registerButton.click();
        registrationPage.clickRegisterButton();

        // var userMenuDropdown = wait.until(ExpectedConditions
        //    .visibilityOfElementLocated(cssSelector("#fat-menu > a")));
        // assertEquals(userMenuDropdown.getText().toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
        UsersBugRedUsersPage usersPage = new UsersBugRedUsersPage(driver);
        var userMenuDropdown = usersPage.getUsernameFromDropdown();
        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }

    @Test
    public void registerUserWithoutCommentsTest() {
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
