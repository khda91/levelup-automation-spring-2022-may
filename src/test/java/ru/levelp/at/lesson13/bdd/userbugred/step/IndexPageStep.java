package ru.levelp.at.lesson13.bdd.userbugred.step;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.userbugred.UsersBugRedUsersPage;
import ru.levelp.at.lesson13.bdd.userbugred.context.TestContext;
import ru.levelp.at.lesson13.bdd.userbugred.model.User;

public class IndexPageStep {

    private UsersBugRedUsersPage usersPage;

    public IndexPageStep() {
        var driver = (WebDriver) TestContext.getInstance().getAttribute("driver");
        this.usersPage = new UsersBugRedUsersPage(driver);
    }

    @Then("displayed username should be equal {string} in header on the Index page")
    public void displayedUsernameShouldBeEqualInHeader(String expectedUsername) {
        assertEquals(usersPage.getUsernameFromDropdown(), expectedUsername);
    }

    @Then("displayed username should be equal generated username in header on the Index page")
    public void displayedUsernameShouldBeEqualInHeader() {
        var user = (User) TestContext.getInstance().getAttribute("randomUser");
        assertEquals(usersPage.getUsernameFromDropdown(), user.getUsername());
    }
}
