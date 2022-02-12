package com.dealx.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserFactory
{
    private static WebDriver driver = null;

    @BeforeTest
    public static WebDriver startBrowser()
    {
        RepositoryProperties property = new RepositoryProperties();
        String Url = property.EnvProperties("url");
        String Browser = property.EnvProperties("browser");

        String browser = Browser.toLowerCase();

        switch(browser)
        {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-infobars");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.get(Url);
        driver.manage().window().maximize();
        return driver;
    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
