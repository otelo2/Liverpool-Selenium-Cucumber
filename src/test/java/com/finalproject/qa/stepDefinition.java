package com.finalproject.qa;

import static org.junit.Assert.*;

import com.finalproject.qa.pageobjects.*;
import org.openqa.selenium.*;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class stepDefinition {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    String productCode;

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^navigate to Liverpool home page in (.+)$")
    public void navigate_to_liverpool_home_page_in_firefox(String browser) {
        driver = WebDriverProvider.createDriver(browser);
        homePage = new HomePage(driver);
    }

    @When("^type the name of an (.+) in the search bar$")
    public void type_the_name_of_an_gap_in_the_search_bar(String search) {
        homePage.writeInSearchBar(search);
        searchPage = homePage.goToShoppingSearchPage();
    }
    @When("locate the search bar on the top of the screen and click on it")
    public void locate_the_search_bar_on_the_top_of_the_screen_and_click_on_it() {
        WebElement searchBar = homePage.getSearchBar();
        searchBar.click();
    }

    @Then("the search results page is displayed")
    public void the_search_results_page_is_displayed() throws InterruptedException {
        assertTrue(searchPage.ifInSearchPage());
    }
    @Then("a screen states that there are no matches for the input data is displayed")
    public void a_screen_states_that_there_are_no_matches_for_the_input_data_is_displayed() {
        assertTrue(searchPage.getProductNotFoundText().contains("Lo sentimos, no encontramos nada para"));
    }

    @Then("all the products of the store are displayed")
    public void all_the_products_of_the_store_are_displayed() {
        // Write code here that turns the phrase above into concrete actions
        assertNotNull(searchPage.getProductsList());
    }

    @Then("^a special screen with products of that (.+) shows up$")
    public void a_special_screen_with_products_of_that_brand_shows_up(String brand) {
        System.out.println(searchPage.getBrandPageNameText());
        System.out.println(brand);
        assertEquals(brand, searchPage.getBrandPageNameText());
    }

    @Then("^a normal screen with products of that (.+) shows up$")
    public void a_normal_screen_with_products_of_that_brand_shows_up(String brand) {
        assertEquals(brand, searchPage.getSearchResultText());
    }

    @When("^type the (.+) of an article and press Enter$")
    public void type_the_rojo_of_an_article_and_press(String characteristic) {
        homePage.writeInSearchBar(characteristic);
        searchPage = homePage.goToShoppingSearchPage();
    }
    @Then("^a screen with products that match the (.+) shows up$")
    public void a_screen_with_products_that_match_the_physical_characteristic_shows_up(String characteristic) {
        WebElement product = searchPage.getProductsList().get(0);
        assertEquals(characteristic,searchPage.getProductName(product));
    }
    @When("Click on one of the search results")
    public void click_on_one_of_the_search_results() {
        WebElement product = searchPage.getProductsList().get(4);
        searchPage.openProductPage(product);
    }
    @When("Locate the product code and copy it")
    public void locate_the_product_code_and_copy_it() {
        productCode = productPage.getProductCodeText();
    }
    @Then("product page for the article is displayed")
    public void product_page_for_the_article_is_displayed() {
        assertTrue(productPage.ifInProductPage());
    }
}
