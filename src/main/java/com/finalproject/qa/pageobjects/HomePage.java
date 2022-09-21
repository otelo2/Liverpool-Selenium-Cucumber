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
    }

    @FindBy(linkText = "Sign In")
    WebElement signInButton;

    @FindBy(linkText = "Create an Account")
    WebElement createAnAccountButton;

    public LoginPage goToLoginPage(WebDriver driver) {
        signInButton.click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }
}
