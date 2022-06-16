package ru.levelp.at.lesson0507.selenium.page.objects.composite.component;

import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OzonProductCardComponent extends OzonBaseComponent {

    private static final String PRODUCT_CARD_TITLE_LOCATOR = ".//a[contains(@class, 'j0q')]/span/span";
    private static final String PRODUCT_CARD_DISCOUNT_PRICE_TITLE = ".//*[@class='ui-o0']/span";

    private final WebElement rootElement;

    public OzonProductCardComponent(WebDriver driver, final WebElement rootElement) {
        super(driver);
        this.rootElement = rootElement;
    }

    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOf(rootElement
            .findElement(By.xpath(PRODUCT_CARD_TITLE_LOCATOR)))).getText();
    }

    public BigDecimal getDiscountPrice() {
        var price = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(rootElement,
            By.xpath(PRODUCT_CARD_DISCOUNT_PRICE_TITLE))).getText().replaceAll("\\D", "");
        return new BigDecimal(price);
    }
}
