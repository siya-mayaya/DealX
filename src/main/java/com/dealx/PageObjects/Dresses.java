package com.dealx.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Dresses
{
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/h1/span[1]")
    private WebElement pageHeading;

    public Dresses(WebDriver driver)
    {
        this.driver = driver;
    }

    public String pageHeader()
    {
        String header = pageHeading.getText();
        return header;
    }

    public String pageTitle()
    {
        String title = driver.getTitle();
        return title;
    }
}
