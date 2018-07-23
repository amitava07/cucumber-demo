package com.example.step.definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver webDriver;

    @Before
    public void setup() {
        // Instantiate the selenium driver
        System.setProperty("webdriver.chrome.driver", "/Users/amitava/Documents/bdd/jars/chromedriver");
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
