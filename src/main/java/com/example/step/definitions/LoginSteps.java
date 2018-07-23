package com.example.step.definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Use cucumber to bind the feature file steps to Java Code
 * Also called glue code - step definitions or step implementations
 *
 * NOTE : cucumber.api.java.Before and cucumber.api.java.After annotations are cucumber hooks
 */
public class LoginSteps {
    private WebDriver webDriver = Hooks.webDriver;

    @Given("the user is on login page")
    public void user_on_login_page() {
        // Navigate to the login page
        webDriver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @When("the user enters valid credentials")
    public void user_enters_valid_credentias() {
        webDriver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
        webDriver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
        webDriver.findElement(By.id("MainContent_btnLogin")).click();
    }

    @Then("the user should be able to see their account balance")
    public void user_should_see_account_balance() {
        String welcomeMessage = "Logged in successfully";
        // the xpath expression grabs everything in the body
        String bodyText = webDriver.findElement(By.xpath("html/body")).getText();
        Assert.assertTrue(bodyText.contains(welcomeMessage));
    }

    @When("the user enters bad credentials")
    public void user_enters_bad_credentias() {
        webDriver.findElement(By.id("MainContent_txtUserName")).sendKeys("badlogin@testemail.com");
        webDriver.findElement(By.id("MainContent_txtPassword")).sendKeys("badpassword");
        webDriver.findElement(By.id("MainContent_btnLogin")).click();
    }

    @Then("the user should not be able to login")
    public void user_should_not_login() {
        String welcomeMessage = "Logged in successfully";
        // the xpath expression grabs everything in the body
        String bodyText = webDriver.findElement(By.xpath("html/body")).getText();
        Assert.assertTrue(!bodyText.contains(welcomeMessage));
    }

    @And("the user should get an invalid login message")
    public void user_gets_invalid_message() {
        String message = "Invalid user name, try again!";
        // the xpath expression grabs everything in the body
        String bodyText = webDriver.findElement(By.xpath("html/body")).getText();
        Assert.assertTrue(bodyText.contains(message));
    }
}
