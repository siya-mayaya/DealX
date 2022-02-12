package com.dealx.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignIn
{
    private final WebDriver driver;
    String EmailAddress = "siyar.mayaya@gmail.com";
    String Password = "Siya12345";

   /* @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement password;

    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement loginBtn;*/

    public SignIn(WebDriver driver)
    {
        this.driver = driver;
    }

    public SignIn enterEmailAddress()
    {
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys(EmailAddress);
        return this;
    }

    public SignIn enterPassword()
    {
        WebElement password = driver.findElement(By.id("passwd"));
        password.clear();
        password.sendKeys(Password);
        return this;
    }

    public MyAccounts clickSignIn()
    {
        WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));
        loginBtn.click();
        return new MyAccounts(driver);
    }
}
