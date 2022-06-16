package ru.levelp.at.lesson0507.selenium.page.objects.composite.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OzonHeaderComponent extends OzonBaseComponent {

    @FindBy(xpath = "//*[@id='stickyHeader']//div[@data-widget='catalogMenu']//button")
    private WebElement catalogButton;

    public OzonHeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void clickCatalogButton() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogButton)).click();
    }

    public void clickCategoryLink(final String categoryLinkTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(categoryLinkTitle))).click();
    }
}
