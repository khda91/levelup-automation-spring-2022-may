package ru.levelp.at.lesson1011.cicd.ui.test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Param;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.model.Parameter.Mode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Регитрация пользователя")
@Feature("Неуспешная регистрация пользователя")
public class UsersBugRedAllureNegativeDataProviderExampleTest extends AbstractSeleniumBaseTest {

    @DataProvider
    public Object[][] invalidRegistrationDataProvider() {
        return new Object[][] {
            {FAKER.name().fullName(), FAKER.name().username(),
                FAKER.internet().password(), "register_not_correct_field (email)"},
            {FAKER.name().fullName(), FAKER.name().username(),
                FAKER.internet().password(), "register_not_correct_field (email)"}
        };
    }

    @Test(description = "Тест неуспешной регистрации пользователя data provider",
          dataProvider = "invalidRegistrationDataProvider")
    @Severity(SeverityLevel.MINOR)
    @Issue("BUG-6578")
    @Description("Проверяем неправитльные данные для регистрации пользователя")
    @Story("Негативная регистрация пользователя 1")
    public void registerUserNegativeTest(@Param(name = "username") final String username,
                                         @Param(name = "email") final String email,
                                         @Param(name = "password", mode = Mode.MASKED) final String password,
                                         @Param(name = "expected error message") final String expectedErrorMessage) {
        steps.openUserBugRedApplication();
        steps.registrationInApplicationWithParamNames(username, email, password);
        steps.assertThatErrorTextEqualsExpected(expectedErrorMessage);
    }
}
