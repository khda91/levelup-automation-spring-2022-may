package ru.level.at.taf.skeleton.trello.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.level.at.taf.skeleton.trello.configuration.provider.ConfigProvider;
import ru.level.at.taf.skeleton.trello.step.BoardStep;
import ru.level.at.taf.skeleton.trello.step.LoginStep;

@DisplayName("Тесты на карточки Trello")
public class TrelloCardTest extends AbstractTrelloBaseTest {

    private String createdBoardId;
    private BoardStep boardStep;

    @BeforeEach
    void setUp() {
        boardStep = new BoardStep();
        // Создаём доску
        createdBoardId = boardStep.createBoard("Test_Lesson");

        var loginStep = new LoginStep();
        var uiApplicationConfig = ConfigProvider.getUiApplicationConfig();
        // открыть страницу логина
        loginStep.openLoginPage();

        // логинимся
        loginStep.login(uiApplicationConfig.username(), uiApplicationConfig.password());
    }

    @Test
    @DisplayName("Создание карточки в trello доске")
    void createCardInBoardTest() {
        // открываем созданную доску
        boardStep.openBoardByName("Test_Lesson");

        // добавляем карточку
        boardStep.addCardToBoardByName("some text");

        // проверяем, что карточка создалась
        boardStep.cardShouldHaveText("some text");
    }

    @Override
    @AfterEach
    void tearDown() {
        super.tearDown();
        // удаляем доску
        boardStep.deleteBoard(createdBoardId);
    }
}
