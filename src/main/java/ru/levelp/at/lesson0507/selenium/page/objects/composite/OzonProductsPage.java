package ru.levelp.at.lesson0507.selenium.page.objects.composite;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.lesson0507.selenium.page.objects.composite.component.OzonProductCardComponent;

public class OzonProductsPage extends OzonBasePage {

    //    @FindBy(xpath = "//div[contains(@class, 'r7j')]")
    //    private List<WebElement> productCardElements;

    public OzonProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("/category/smartfony-15502/");
    }

    public OzonProductCardComponent getProductCard(final int index) {
        List<WebElement> productCardElements =
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
                .xpath("//div[contains(@class, 'r7j')]"), 2));
        return new OzonProductCardComponent(driver, productCardElements.get(index - 1));
    }
}
