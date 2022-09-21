package com.finalproject.qa;

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
        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector(
                "body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"))
                .sendKeys("jsajdasjdjasd");
        Thread.sleep(1000);
        driver.quit();

    }
}
