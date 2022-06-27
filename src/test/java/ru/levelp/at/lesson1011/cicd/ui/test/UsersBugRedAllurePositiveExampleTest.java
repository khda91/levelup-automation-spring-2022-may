package ru.levelp.at.lesson1011.cicd.ui.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.util.ResultsUtils;
import org.testng.annotations.Test;

@Epic("Регитрация пользователя")
@Link(value = "Тестовая ссылка Эпик", url = "http://levelp.jira.com/browse/XXXX-9876")
@Feature("Успешная регистрация пользователя")
@Link(value = "Тестовая ссылка Фича", url = "http://levelp.jira.com/browse/XXXX-9867")
public class UsersBugRedAllurePositiveExampleTest extends AbstractSeleniumBaseTest {

    @Test(description = "Тест по регистрации пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("XXXX-1234")
    @Story("Позитивная регистрация пользователя")
    @Link(value = "Тестовая ссылка Стори", url = "http://levelp.jira.com/browse/XXXX-9856")
    public void registerUserTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        steps.openUserBugRedApplication();
        steps.registrationInApplication(username, email, password);
        steps.assertThatLoginUsernameEqualsToExpected(username);
    }

    @Test(description = "Тест по регистрации пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("XXXX-1234")
    @Story("Позитивная регистрация пользователя")
    public void registerUserWithFailTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.name().username();
        var password = FAKER.internet().password();

        steps.openUserBugRedApplication();
        steps.registrationInApplication(username, email, password);
        steps.assertThatLoginUsernameEqualsToExpected(username);
    }
}
