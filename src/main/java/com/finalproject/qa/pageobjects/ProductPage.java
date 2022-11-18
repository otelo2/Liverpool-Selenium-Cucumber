package com.finalproject.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".m-product__information--code")
    WebElement productCode;

    public String getProductCodeText(){return productCode.getText();}

    public boolean ifInProductPage() {
        return driver.getCurrentUrl().contains("https://www.liverpool.com.mx/tienda/pdp/");
    }

}
