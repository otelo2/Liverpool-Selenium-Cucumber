package com.finalproject.qa;

import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.*;

import com.finalproject.qa.pageobjects.HomePage;
import com.finalproject.qa.pageobjects.LoginPage;
import com.finalproject.qa.pageobjects.ShoppingCartPage;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class stepDefinition {
    WebDriver driver;
    ConfigFileReader configFileReader;
    HomePage homePage;
    LoginPage loginPage;
    ShoppingCartPage shoppingCartPage;
    String actualPrice;

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

    @Given("i am in the home page")
    public void i_am_in_the_home_page() {
        assertTrue(homePage.ifInHomePage());
    }

    @When("^i check the price of the (.+) product$")
    public void i_check_the_price_of_the_product(String number) {
        List<WebElement> elementList = homePage.getProductsList();
        Integer numberInteger = Integer.parseInt(number);
        actualPrice = homePage.getPriceOfProduct(elementList.get(numberInteger));
    }

    @Then("^the actual price should match the (.+) price$")
    public void the_actual_price_should_match_the_price(String expected) {
        assertEquals(expected, actualPrice);
    }

    @When("^i add the (.+) product to the cart$")
    public void i_add_the_product_to_the_cart(String number) {
        List<WebElement> elementList = homePage.getProductsList();
        Integer numberInteger = Integer.parseInt(number);
        homePage.clickAddToCartButton(elementList.get(numberInteger));
    }

    @Then("^the name of the product in the cart should match the (.+) name$")
    public void the_name_of_the_product_in_the_cart_should_match_the_name(String expected) {
        List<WebElement> elementList = shoppingCartPage.getCartProductsList();
        String actualName = shoppingCartPage.getProductName(elementList.get(0));

        assertEquals(expected, actualName);
    }

    @And("^i go to the shopping cart page$")
    public void i_go_to_the_shopping_cart_page() {
        shoppingCartPage = homePage.goToShoppingCartPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
