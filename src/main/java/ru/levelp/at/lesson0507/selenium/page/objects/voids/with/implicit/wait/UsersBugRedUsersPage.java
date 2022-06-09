package ru.levelp.at.lesson0507.selenium.page.objects.voids.with.implicit.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersBugRedUsersPage extends UsersBugRedBasePage {

    @FindBy(css = "#fat-menu > a")
    private WebElement userMenuDropdown;

    public UsersBugRedUsersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("/");
    }

    public String getUsernameFromDropdown() {
        return userMenuDropdown.getText();
    }
}
