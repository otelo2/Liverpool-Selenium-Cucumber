package com.finalproject.qa;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import com.finalproject.qa.pageobjects.HomePage;
import com.finalproject.qa.pageobjects.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class stepDefinition {
    WebDriver driver;
    ConfigFileReader configFileReader;
    HomePage homePage;
    LoginPage loginPage;

    @Given("^navigate to Saucedemo login page in (.+)$")
    public void navigate_to_saucedemo_login_page_in(String browser) {
        driver = WebDriverProvider.createDriver(browser);
        loginPage = new LoginPage(driver);
    }

    @When("^type the non existing username (.+)$")
    public void type_the_non_existing_username(String username) {
        loginPage.writeUsername(username);
    }

    @And("^type the non existing password (.+)$")
    public void type_the_non_existing_password(String password) {
        loginPage.writePassword(password);
    }

    @And("^click on the login button$")
    public void click_on_the_login_button() {
        loginPage.clickSignInButton();

    }

    @Then("^an error message should appear (.+)$")
    public void an_error_message_should_appear(String error) {
        String expectedErrorMessage = error;

        String actualErrorMessage = loginPage.getLoginErrorMessage();

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("login with the standard_user credentials")
    public void login_with_the_standard_user_credentials() {
        homePage = loginPage.logIn("standard_user", "secret_sauce");
    }

    @Then("i should log in to the store home page")
    public void i_should_log_in_to_the_store_home_page() {
        String expectedHeader = "PRODUCTS";

        String actualHeader = homePage.getHeaderText();

        assertEquals(expectedHeader, actualHeader);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
