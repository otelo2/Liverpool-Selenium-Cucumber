package com.finalproject.qa.pageobjects;

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

    public void logIn(String email, String password) {
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        signInButton.click();
    }

}
