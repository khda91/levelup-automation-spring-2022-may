package ru.level.at.taf.skeleton.trello.service.page.objects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoardTrelloPage extends AbstractTrelloBasePage {

    public BoardTrelloPage(WebDriver driver) {
        super(driver);
    }

    public void addCard() {
        var locator = "//*[@id='board']//div[contains(@class, 'js-list-content') and "
            + ".//div[contains(@class, 'list-header')]"
            + "/h2[text()='To Do']]//div[contains(@class, 'card-composer-container')]//a";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
    }

    public void fillToDoColumnCard(String cardText) {
        var locator = "//*[@id='board']//div[contains(@class, 'js-list-content') and "
            + ".//div[contains(@class, 'list-header')]"
            + "/h2[text()='To Do']]//div[contains(@class, 'list-cards')]//textarea";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(cardText + Keys.ENTER);
    }

    public String getCardText() {
        var locator = "//*[@id='board']//div[contains(@class, 'js-list-content') and "
            + ".//div[contains(@class, 'list-header')]/h2[text()='To Do']]//div[contains(@class, 'list-cards')]"
            + "/a[contains(@class, 'list-card')]";
        List<WebElement> cards = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(locator), 0));
        return cards.get(0).getText();
    }

    @Override
    public void open() {

    }
}
