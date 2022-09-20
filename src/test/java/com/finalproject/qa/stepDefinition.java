package com.finalproject.qa;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.finalproject.qa.ConfigFileReader;

import io.cucumber.java.en.*;

public class stepDefinition {
    WebDriver driver;
    ConfigFileReader configFileReader;

    @Given("^sample feature file is ready$")
    public void givenStatment() {
        System.out.println("Given statement executed successfully");
    }

    @When("^I run the feature file$")
    public void whenStatement() {
        System.out.println("When statement execueted successfully");
    }

    @Then("^run should be successful$")
    public void thenStatment() {
        System.out.println("Then statement executed successfully");
    }

    @Given("navigate to Gmail page")
    public void navigate_to_Gmail_page() {
        driver = WebDriverProvider.createDriver("edge");

        driver.get("http://www.gmail.com");
    }

    @When("user logged in using username as \\{username} and password as \\{password}")
    public void user_logged_in_using_username_as_and_password_as(String username, String password) {
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='signIn']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("home page should be displayed")
    public void verifySuccessful() {
        String expectedText = "Gmail";
        String actualText = driver.findElement(By.xpath("//*[@id='gbq1']/div/a/span")).getText();
        assertTrue("Login not successful", expectedText.equals(actualText));
    }

}
