package com.finalproject.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    WebElement productsHeaderText;

    By productListBy = By.cssSelector("#inventory_container > div > div");

    public String getHeaderText() {
        return productsHeaderText.getText();
    }

    public List<WebElement> getProductsList() {
        return driver.findElements(productListBy);
    }

    public String getPriceOfProduct(WebElement product) {
        return product.findElement(By.cssSelector("div.inventory_item_description > div.pricebar > div")).getText();
    }

    public boolean ifInHomePage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");

    }
}