package com.finalproject.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.col-lg-auto:nth-child(2) > a:nth-child(1)")
    WebElement homeButton;

    @FindBy(css = "a-breadcrumb__label 6")
    WebElement searchResultText;

    By brandPageNameTextBy = By.cssSelector(".a-title-section-leftMenu");

    By productTextNotFoundBy = By.cssSelector(".o-nullproduct-title-query");

    By listOfProductsBy = By.cssSelector("html body.lp div#__next div.min-vh-100 div.container-fluid.o-main-container.p-0.o-plp-secondaryContainer div.container.o-container__secondary.search--- div.row.mt-lg-3.m-row-bootstrap main.col-lg-9.m-column_mainContent div.row div.col-12.p-2.p-lg-1 div.o-listing__products ul.m-product__listingPlp li.m-product__card.card-masonry.a");

    public List<WebElement> getProductsList() {
        return driver.findElements(listOfProductsBy);
    }

    public String getProductName(WebElement product) {
        return product.findElement(By.cssSelector(".m-figureCard__figcaption card-body d-flex flex-column align-items-start a-plp-product-info")).getText();
    }

    public String getProductCost(WebElement product) {
        return product.findElement(By.className("a-card-discount")).getText();
    }

    public WebElement getProductImageSection(WebElement product) {
        return product.findElement(By.className("o-card__image__container"));
    }

    public String getProductNotFoundText(){ return driver.findElement(productTextNotFoundBy).getText();}

    public String getBrandPageNameText(){ return driver.findElement(brandPageNameTextBy).getText();}

    public String getSearchResultText(){return searchResultText.getText();}

    public boolean ifInSearchPage() throws InterruptedException {
        Thread.sleep(2000);
        return driver.getCurrentUrl().contains("https://www.liverpool.com.mx/tienda?s=");
    }

    public ProductPage openProductPage(WebElement product){
        getProductImageSection(product).click();
        return new ProductPage(driver);
    }

    public HomePage goToHomePage(){
        homeButton.click();
        return new HomePage(driver);
    }
}
