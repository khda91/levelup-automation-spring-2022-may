package ru.levelp.at.lesson1011.cicd.ui.test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.levelp.at.lesson1011.cicd.ui.listener.AllureListener;

@Epic("Регитрация пользователя")
@Feature("Неуспешная регистрация пользователя")
@Listeners({AllureListener.class})
public class UsersBugRedAllureNegativeExampleTest extends AbstractSeleniumBaseTest {

    @Test(description = "Тест неуспешной регистрации пользователя")
    @Severity(SeverityLevel.MINOR)
    @Issue("BUG-6578")
    @Description("Проверяем неправитльные данные для регистрации пользователя")
    @Story("Негативная регистрация пользователя 1")
    public void registerUserNegativeTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.name().username();
        var password = FAKER.internet().password();

        steps.openUserBugRedApplication();
        steps.registrationInApplicationWithParamNames(username, email, password);
        steps.assertThatErrorTextEqualsExpected("register_not_correct_field (email)");
    }

    @Test(description = "Тест неуспешной регистрации пользователя с набором багов")
    @Severity(SeverityLevel.MINOR)
    @Issues({@Issue("BUG-6888"), @Issue("BUG-157")})
    @Story("Негативная регистрация пользователя 2")
    public void registerUserNegativeWithIssuesTest() {
        var username = FAKER.name().fullName();
        var email = FAKER.name().username();
        var password = FAKER.internet().password();

        steps.openUserBugRedApplication();
        steps.registrationInApplication(username, email, password);
        steps.assertThatErrorTextEqualsExpected("register_not_correct_field (email)");
    }
}
