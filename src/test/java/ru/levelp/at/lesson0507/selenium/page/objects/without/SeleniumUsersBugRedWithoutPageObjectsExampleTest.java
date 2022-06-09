package ru.levelp.at.lesson0507.selenium.page.objects.without;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

import java.util.Locale;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.AbstractSeleniumBaseTest;

public class SeleniumUsersBugRedWithoutPageObjectsExampleTest extends AbstractSeleniumBaseTest {

    @Test
    public void registerUserTest() {
        driver.navigate().to(USERS_BUGRED_LOGIN_REG_PAGE_URL);

        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var nameInputField = wait.until(ExpectedConditions
            .visibilityOfElementLocated(xpath("//form[contains(@action, 'register')]//*[@name='name']")));
        nameInputField.sendKeys(username);

        var emailInputField = wait.until(ExpectedConditions
            .visibilityOfElementLocated(xpath("//form[contains(@action, 'register')]//*[@name='email']")));
        emailInputField.sendKeys(email);

        var passwordInputField = wait.until(ExpectedConditions
            .visibilityOfElementLocated(xpath("//form[contains(@action, 'register')]//*[@name='password']")));
        passwordInputField.sendKeys(password);

        var registerButton = wait.until(ExpectedConditions
            .elementToBeClickable(xpath("//form[contains(@action, 'register')]//*[@name='act_register_now']")));
        registerButton.click();

        var userMenuDropdown = wait.until(ExpectedConditions
            .visibilityOfElementLocated(cssSelector("#fat-menu > a")));
        assertEquals(userMenuDropdown.getText().toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }
}
