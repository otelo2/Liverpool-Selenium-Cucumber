package com.finalproject.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    By cartProductsBy = By.cssSelector("#cart_contents_container > div > div.cart_list > div");

    public List<WebElement> getCartProductsList() {
        return driver.findElements(cartProductsBy);
    }

    public String getProductName(WebElement product) {
        return product.findElement(By.className("inventory_item_name")).getText();
    }

    public String getProductDescription(WebElement product) {
        return product.findElement(By.className("inventory_item_desc")).getText();
    }

    public String getProductCost(WebElement product) {
        return product.findElement(By.className("inventory_item_price")).getText();
    }

    public void removeProductFromCart(WebElement product) {
        product.findElement(By.className("btn btn_secondary btn_small cart_button")).click();
    }

    public boolean ifInShoppingCartPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html");
    }

    public HomePage goToHomePage() {
        continueShoppingButton.click();
        return new HomePage(driver);
    }

    public CheckoutPage goToCheckoutPage() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

}
