package com.dealx.PageObjects;

import org.openqa.selenium.*;

public class Home
{
    private final WebDriver driver;

//    @FindBy(how = How.ID, using = "search_query_top")
//    private WebElement searchInputField;
//
//    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default button-search']")
//    private WebElement searchBtn;

    public Home(WebDriver driver)
    {
        this.driver = driver;
    }

    public Home enterSearchCriteria(String searchTerm) throws InterruptedException
    {
        WebElement searchInputField = driver.findElement(By.id("search_query_top"));

            Thread.sleep(5000);
            searchInputField.clear();
            searchInputField.sendKeys(searchTerm);

        return this;
    }

    public Home clickSearchBtn()
    {
        WebElement searchBtn = driver.findElement(By.xpath("//button[@class='btn btn-default button-search']"));
        searchBtn.click();
        return this;
    }

    public SignIn clickSignInBtn()
    {
        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        return new SignIn(driver);
    }

    public Home scrollAndHover()
    {
        WebElement item = driver.findElement(By.xpath(""));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", item);
        return this;
    }
}
