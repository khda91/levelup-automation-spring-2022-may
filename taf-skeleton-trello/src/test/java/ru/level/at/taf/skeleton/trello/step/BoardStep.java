package ru.level.at.taf.skeleton.trello.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import ru.level.at.taf.skeleton.trello.service.api.client.BoardApiClient;
import ru.level.at.taf.skeleton.trello.service.page.objects.BoardTrelloPage;
import ru.level.at.taf.skeleton.trello.service.page.objects.BoardsTrelloPage;

public class BoardStep extends AbstractBaseStep {

    private BoardApiClient boardApiClient;
    private BoardsTrelloPage boardsPage;
    private BoardTrelloPage boardPage;

    public BoardStep() {
        this.boardApiClient = new BoardApiClient();
        this.boardsPage = new BoardsTrelloPage(driver);
        this.boardPage = new BoardTrelloPage(driver);
    }

    @Step("Создаём доску: {boardName}")
    public String createBoard(String boardName) {
        return boardApiClient.create(boardName);
    }

    @Step("Удаляем доску с id: {id}")
    public void deleteBoard(String id) {
        boardApiClient.delete(id);
    }

    @Step("Открываем доску {name}")
    public void openBoardByName(final String name) {
        boardsPage.openBoard(name);
    }

    @Step("Добавляем карточку с текстом {cardText}")
    public void addCardToBoardByName(final String cardText) {
        boardPage.addCard();
        boardPage.fillToDoColumnCard(cardText);
    }

    @Step("У карточки должен быть текст: {text}")
    public void cardShouldHaveText(String text) {
        assertThat(boardPage.getCardText())
            .isEqualTo(text);
    }
}
