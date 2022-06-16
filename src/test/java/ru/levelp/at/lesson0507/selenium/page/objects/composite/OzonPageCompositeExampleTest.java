package ru.levelp.at.lesson0507.selenium.page.objects.composite;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.AbstractSeleniumBaseTest;

public class OzonPageCompositeExampleTest extends AbstractSeleniumBaseTest {

    @Test
    public void selectCategoryTest() {
        // var homePage = new OzonHomePage(driver);

        // homePage.open();
        // homePage.header().clickCatalogButton();
        // homePage.header().clickCategoryLink("Смартфоны");

        var productsPage = new OzonProductsPage(driver);
        productsPage.open();

        var productCard = productsPage.getProductCard(2);

        assertEquals(productCard.getProductTitle(), "Смартфон Motorola Moto e20 2/32 ГБ, синий");
        assertEquals(productCard.getDiscountPrice(), new BigDecimal("7778"));
    }
}
