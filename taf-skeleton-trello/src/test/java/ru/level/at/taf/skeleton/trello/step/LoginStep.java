package ru.level.at.taf.skeleton.trello.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import ru.level.at.taf.skeleton.trello.service.page.objects.AtlassianLoginPage;
import ru.level.at.taf.skeleton.trello.service.page.objects.LoginTrelloPage;

public class LoginStep extends AbstractBaseStep {

    private LoginTrelloPage loginPage;

    public LoginStep() {
        super();
        loginPage = new LoginTrelloPage(driver);
    }

    @Step("Окрыть страницу trello login")
    public void openLoginPage() {
        loginPage.open();
    }

    @Step("Логинимся пользователем: {username}")
    public void login(final String username, final String password) {
        loginPage.fillUsernameTextField(username);
        loginPage.fillPasswordTextField(password);
        loginPage.clickLoginButton();

        var atlassianLoginPage = new AtlassianLoginPage(driver);
        atlassianLoginPage.fillPasswordTextField(password);
        atlassianLoginPage.clickLoginButton();
    }

    @Step("Проверка, что тайтл у пользователя совпадает с {expectedTitle}")
    public void memberMenuButtonShouldHaveTitle(final String expectedTitle) {
        assertThat(loginPage.getMemberMenuButtonTitle())
            .as("Имя пользователя не совпадает")
            .isEqualTo(expectedTitle);
    }
}
