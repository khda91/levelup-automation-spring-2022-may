package ru.levelp.at.lesson0507.selenium.page.objects.fluent.without.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsersBugRedUsersPage extends UsersBugRedBasePage {

    @FindBy(css = "#fat-menu > a")
    private WebElement userMenuDropdown;

    public UsersBugRedUsersPage(WebDriver driver) {
        super(driver);
    }

    public UsersBugRedUsersPage open() {
        open("/");
        return this;
    }

    public String getUsernameFromDropdown() {
        return wait.until(ExpectedConditions.visibilityOf(userMenuDropdown)).getText();
    }
}
