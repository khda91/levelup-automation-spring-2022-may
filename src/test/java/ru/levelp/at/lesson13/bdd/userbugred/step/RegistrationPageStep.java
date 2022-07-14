package ru.levelp.at.lesson13.bdd.userbugred.step;

import com.github.javafaker.Faker;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.userbugred.UsersBugRedLoginRegistrationPage;
import ru.levelp.at.lesson13.bdd.userbugred.context.TestContext;
import ru.levelp.at.lesson13.bdd.userbugred.model.User;

public class RegistrationPageStep {

    private UsersBugRedLoginRegistrationPage registrationPage;

    public RegistrationPageStep() {
        var driver = (WebDriver) TestContext.getInstance().getAttribute("driver");
        this.registrationPage = new UsersBugRedLoginRegistrationPage(driver);
    }

    @Given("I open User Bug Red Registration page")
    public void openRegistrationPage() {
        registrationPage.open();
    }

    @When("I enter {string} into username text field in Registration section on the Registration page")
    public void enterUsernameIntoUsernameTextFieldInRegistrationSection(String username) {
        registrationPage.fillUsernameInputField(username);
    }

    @When("I enter {string} into email text field in Registration section on the Registration page")
    public void enterEmailIntoEmailTextFieldInRegistrationSection(String email) {
        registrationPage.fillEmailInputField(email);
    }

    @When("I enter {string} into password text field in Registration section on the Registration page")
    public void enterPasswordIntoPasswordTextFieldInRegistrationSection(String password) {
        registrationPage.fillPasswordInputField(password);
    }

    @When("I click on register button in Registration section on the Registration page")
    public void clickOnRegisterButtonInRegistrationSection() {
        registrationPage.clickRegisterButton();
    }

    @When("I register {randomUser} in Registration section on the Registration page")
    public void registerRandomUserInRegistrationSectionOnTheRegistrationPage(User user) {
        TestContext.getInstance().addAttribute("randomUser", user);
        registrationPage.fillUsernameInputField(user.getUsername());
        registrationPage.fillEmailInputField(user.getEmail());
        registrationPage.fillPasswordInputField(user.getPassword());
        registrationPage.clickRegisterButton();
    }

    @ParameterType("random user")
    public User randomUser(String str) {
        final var faker = new Faker();
        return new User(faker.name().username(), faker.internet().emailAddress(), faker.internet().password());
    }
}
