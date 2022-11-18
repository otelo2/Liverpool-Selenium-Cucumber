package com.finalproject.qa;

import com.finalproject.qa.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        // This is where I test stuff because cucumber sometimes doesn't output anything
        WebDriver driver = WebDriverProvider.createDriver("firefox");
        HomePage homePage = new HomePage(driver);
        homePage.getSearchBar().click();
        homePage.writeInSearchBar("something");
        homePage.clickSearchButton();

        Thread.sleep(2000);

        driver.quit();

    }
}
