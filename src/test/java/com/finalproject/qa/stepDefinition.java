package com.finalproject.qa;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.finalproject.qa.ConfigFileReader;

import io.cucumber.java.After;
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

    @Given("^navigate to Google frontpage in (.+)$")
    public void navigate_to_google_frontpage_in(String browser) throws Throwable {
        System.out.println("Creating browser of " + browser);
        driver = WebDriverProvider.createDriver(browser);
        driver.get("http://www.google.com");
    }

    @When("^perform a search of (.+)$")
    public void perform_a_search_of(String term) throws Throwable {
        WebElement searchBox = driver
                .findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchBox.sendKeys(term);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
    }

    @Then("^search result should be displayed of (.+)$")
    public void search_result_should_be_displayed_of(String term) throws Throwable {
        WebElement searchBarInResults = driver
                .findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[2]/input"));
        System.out.println(searchBarInResults.getAttribute("value"));
        assertEquals(term, searchBarInResults.getAttribute("value"));
        driver.quit();
    }

    // @After
    // public void tearDown() {

    // }

}
