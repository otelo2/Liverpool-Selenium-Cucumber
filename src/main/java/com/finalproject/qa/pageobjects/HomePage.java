package com.finalproject.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://www.liverpool.com.mx/tienda/home");
    }

    @FindBy(css = "#mainSearchbar")
    WebElement searchBar;

    @FindBy(xpath = "/html/body/div[1]/header/div[4]/div[2]/div/div/div/div[3]/div/div/div")
    WebElement searchButton;

    @FindBy(css = "span.a-header__topLink")
    WebElement loginButton;

    public WebElement getSearchBar() {
        return searchBar;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public String getSearchBarText() {
        return searchBar.getText();
    }

    public void writeInSearchBar(String query){ searchBar.sendKeys(query);}

    public void clickSearchButton(){searchButton.click();}

    public SearchPage goToShoppingSearchPage() {
        searchButton.click();
        return new SearchPage(driver);
    }
}