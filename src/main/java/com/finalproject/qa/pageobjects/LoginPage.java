package com.finalproject.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://www.saucedemo.com/");
    }

    @FindBy(css = "#user-name")
    WebElement usernameTextBox;

    @FindBy(css = "#password")
    WebElement passwordTextBox;

    @FindBy(css = "#login-button")
    WebElement signInButton;

    By errorMessageBy = By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3");

    public HomePage logIn(String username, String password) {
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        signInButton.click();
        return new HomePage(driver);
    }

    public void writeUsername(String username) {
        usernameTextBox.sendKeys(username);
    }

    public void writePassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(errorMessageBy).getText();
    }

}
