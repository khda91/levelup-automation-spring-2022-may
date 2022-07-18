package ru.level.at.taf.skeleton.trello.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.level.at.taf.skeleton.trello.configuration.provider.ConfigProvider;
import ru.level.at.taf.skeleton.trello.step.LoginStep;

@DisplayName("Тесты на логин в trello")
public class TrelloLoginTest extends AbstractTrelloBaseTest {

    private LoginStep loginStep;

    @BeforeEach
    void setUp() {
        loginStep = new LoginStep();
    }

    @Test
    @DisplayName("Позитивный логин тест")
    void positiveLoginTest() {
        var uiApplicationConfig = ConfigProvider.getUiApplicationConfig();
        // открыть login.trello
        loginStep.openLoginPage();

        // ввести логин и пароль для сайта
        loginStep.login(uiApplicationConfig.username(), uiApplicationConfig.password());

        // проверить, что пользователь залогинился
        loginStep.memberMenuButtonShouldHaveTitle(uiApplicationConfig.title());
    }
}
