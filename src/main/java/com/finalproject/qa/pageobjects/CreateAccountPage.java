package com.finalproject.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends CommonElements {
    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    WebElement firstNameTextField;

    @FindBy(id = "lastname")
    WebElement lastNameTextField;

    @FindBy(css = "#is_subscribed")
    WebElement newsletterCheckbox;

    @FindBy(css = "#email_address")
    WebElement emailTextField;

    @FindBy(css = "#password")
    WebElement passwordTextField;

    @FindBy(css = "#password-confirmation")
    WebElement confirmPasswordTextField;

    @FindBy(css = "#form-validate > div > div.primary > button")
    WebElement createAccountButton;

    public void addPersonalInformation(String firstName, String lastName, boolean signUpToNewsletter) {
        firstNameTextField.sendKeys(firstName);
        lastNameTextField.sendKeys(lastName);
        if (signUpToNewsletter)
            newsletterCheckbox.click();
    }

    public void addSignInInformation(String email, String password, String passwordConfirmation) {
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        confirmPasswordTextField.sendKeys(passwordConfirmation);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

}
