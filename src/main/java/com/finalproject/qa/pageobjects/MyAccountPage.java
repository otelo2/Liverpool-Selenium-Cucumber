package com.finalproject.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#maincontent > div.columns > div.column.main > div.block.block-dashboard-info > div.block-content > div.box.box-information > div.box-content > p")
    WebElement personalAndLoginInformation;

    @FindBy(css = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome.active > div > ul > li.authorization-link > a")
    WebElement signOutButton;

    public void signOut() {
        signOutButton.click();
    }

}
