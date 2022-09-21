package com.finalproject.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElements {
    WebDriver driver;

    public CommonElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign In")
    WebElement signInButton;

    @FindBy(linkText = "Create an Account")
    WebElement createAnAccountButton;

    @FindBy(css = "body > div.page-wrapper > header > div.header.content > a")
    WebElement websiteLogo;

    @FindBy(css = "#search")
    WebElement searchBarTextField;

    @FindBy(css = "body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a")
    WebElement cartLogo;

    @FindBy(css = "#ui-id-3")
    WebElement whatsNewButton;

    @FindBy(css = "#ui-id-4")
    WebElement womenButton;

    @FindBy(css = "#ui-id-5")
    WebElement menButton;

    @FindBy(css = "#ui-id-6")
    WebElement gearButton;

    @FindBy(css = "#ui-id-7")
    WebElement trainingButton;

    @FindBy(css = "#ui-id-8")
    WebElement saleButton;

    public HomePage goToHomePage(WebDriver driver) {
        websiteLogo.click();
        return new HomePage(driver);
    }

    public LoginPage goToLoginPage(WebDriver driver) {
        signInButton.click();
        return new LoginPage(driver);
    }

    public CreateAccountPage goToCreateAccountPage(WebDriver driver) {
        createAnAccountButton.click();
        return new CreateAccountPage(driver);
    }

}
