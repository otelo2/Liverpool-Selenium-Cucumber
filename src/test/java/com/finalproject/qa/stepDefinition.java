package com.finalproject.qa;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.finalproject.qa.ConfigFileReader;
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
    public void type_the_non_existing_username(String username) throws Throwable {
        loginPage.writeUsername(username);
    }

    @And("^type the non existing password (.+)$")
    public void type_the_non_existing_password(String password) throws Throwable {
        loginPage.writePassword(password);
    }

    @And("^click on the login button$")
    public void click_on_the_login_button() throws Throwable {
        loginPage.clickSignInButton();

    }

    @Then("^an error message should appear$")
    public void an_error_message_should_appear() throws Throwable {
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        String actualErrorMessage = loginPage.getLoginErrorMessage();

        assertEquals(expectedErrorMessage, actualErrorMessage);
        driver.quit();
    }

    // @After
    // public void tearDown() {

    // }

}
