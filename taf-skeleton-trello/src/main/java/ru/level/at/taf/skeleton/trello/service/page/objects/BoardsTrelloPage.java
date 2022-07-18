package ru.level.at.taf.skeleton.trello.service.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoardsTrelloPage extends AbstractTrelloBasePage {

    public BoardsTrelloPage(WebDriver driver) {
        super(driver);
    }

    public void openBoard(final String name) {
        String boardLocator = String.format("//div[@class='board-tile-details-name' and @title='%s']", name);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(boardLocator))).click();
    }

    @Override
    public void open() {
        // не имлементирован
    }
}
