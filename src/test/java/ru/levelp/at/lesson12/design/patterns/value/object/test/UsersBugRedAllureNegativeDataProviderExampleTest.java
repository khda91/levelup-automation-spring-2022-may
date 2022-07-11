package ru.levelp.at.lesson12.design.patterns.value.object.test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Param;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson12.design.patterns.value.object.model.User;

@Epic("Регитрация пользователя")
@Feature("Неуспешная регистрация пользователя")
public class UsersBugRedAllureNegativeDataProviderExampleTest extends AbstractSeleniumBaseTest {

    @DataProvider
    public Object[][] invalidRegistrationDataProvider() {
        return new Object[][] {
            {new User(FAKER.name().fullName(), FAKER.name().username(),
                FAKER.internet().password()), "register_not_correct_field (email)"},
            {new User(FAKER.name().fullName(), FAKER.name().username(),
                FAKER.internet().password()), "register_not_correct_field (email)"}
        };
    }

    @Test(description = "Тест неуспешной регистрации пользователя data provider",
          dataProvider = "invalidRegistrationDataProvider")
    @Severity(SeverityLevel.MINOR)
    @Issue("BUG-6578")
    @Description("Проверяем неправитльные данные для регистрации пользователя")
    @Story("Негативная регистрация пользователя 1")
    public void registerUserNegativeTest(@Param(name = "user") final User user,
                                         @Param(name = "expected error message") final String expectedErrorMessage) {
        steps.openUserBugRedApplication();
        steps.registrationInApplicationWithParamNames(user);
        steps.assertThatErrorTextEqualsExpected(expectedErrorMessage);
    }
}
