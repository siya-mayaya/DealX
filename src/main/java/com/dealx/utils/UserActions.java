package com.dealx.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserActions
{
    private final WebDriver driver;

    public UserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(WebElement element, WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void mouseHover()
    {

    }
}
