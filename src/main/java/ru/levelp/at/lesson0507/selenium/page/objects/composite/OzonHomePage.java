package ru.levelp.at.lesson0507.selenium.page.objects.composite;

import org.openqa.selenium.WebDriver;

public class OzonHomePage extends OzonBasePage {

    protected OzonHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("/");
    }
}
