package ru.levelp.at.lesson0507.selenium.step.design.pattern.users.bug.red.test;

import org.testng.annotations.Test;

public class UsersBugRedStepExampleTest extends AbstractSeleniumBaseTest {

    @Test
    public void registerUserTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        steps.openUserBugRedApplication();
        steps.loginInApplication(username, email, password);
        steps.assertThatLoginUsernameEqualsToExpected(username);
    }

    @Test
    public void registerUserNegativeTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.name().username();
        var password = FAKER.internet().password();

        steps.openUserBugRedApplication();
        steps.loginInApplication(username, email, password);
        steps.assertThatErrorTextEqualsExpected("register_not_correct_field (email)");
    }
}
