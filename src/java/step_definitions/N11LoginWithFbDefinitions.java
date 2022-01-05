package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import screenplay.login.LoginAsUser;
import screenplay.tasks.NavigateTo;
import screenplay.user_interface.N11UserMainPageElements;

public class N11LoginWithFbDefinitions{
    Actor actor = Actor.named("kadir");
    @Managed
    WebDriver webDriver;

    @Given("User navigate to N11 homepage")
    public void userNavigateToN11HomePage() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateTo.theN11HomePage());
    }

    @When("User enter valid credentials {string} and {string} with facebook in login page")
    public void userEnterValidCredentialsWithFacebook(String email, String password) {
        actor.attemptsTo(LoginAsUser.loginThePage(email, password));
    }

    @Then("User should see email {string} in main page")
    public void userShouldSeeEmailInMainPage(String email) {
        actor.attemptsTo(
                Ensure.that(N11UserMainPageElements.USER_ACC_LINK).hasText(email)
        );
    }