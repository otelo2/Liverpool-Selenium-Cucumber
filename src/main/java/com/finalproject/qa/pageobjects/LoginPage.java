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
    }

    @FindBy(css = "#email")
    WebElement emailTextBox;

    @FindBy(css = "#pass")
    WebElement passwordTextBox;

    @FindBy(css = "#send2")
    WebElement signInButton;

    By errorMessageBy = By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div");

    public void logIn(String email, String password) {
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        signInButton.click();
    }

    public void writeEmail(String email) {
        emailTextBox.sendKeys(email);
    }

    public void writePassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getLoginErrorMessage() {
        return driver.findElement(errorMessageBy);
    }

}
