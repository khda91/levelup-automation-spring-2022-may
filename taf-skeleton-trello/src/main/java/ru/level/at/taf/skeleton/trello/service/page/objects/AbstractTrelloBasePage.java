package ru.level.at.taf.skeleton.trello.service.page.objects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.level.at.taf.skeleton.trello.configuration.UiApplicationConfig;
import ru.level.at.taf.skeleton.trello.configuration.provider.ConfigProvider;

public abstract class AbstractTrelloBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//*[@data-test-id='header-member-menu-button']")
    private WebElement memberMenuHeaderButton;

    private final UiApplicationConfig uiApplicationConfig;

    protected AbstractTrelloBasePage(WebDriver driver) {
        uiApplicationConfig = ConfigProvider.getUiApplicationConfig();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(uiApplicationConfig.waitDurationSeconds()));
    }

    protected void open(final String pageRelativeUrl) {
        driver.navigate().to(uiApplicationConfig.url() + pageRelativeUrl);
    }

    public abstract void open();

    public String getMemberMenuButtonTitle() {
        return wait.until(ExpectedConditions.visibilityOf(memberMenuHeaderButton))
                   .getAttribute("title");
    }
}
