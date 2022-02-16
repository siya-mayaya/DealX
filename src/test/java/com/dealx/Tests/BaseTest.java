package com.dealx.Tests;

import com.dealx.PageObjects.Cart;
import com.dealx.PageObjects.Dresses;
import com.dealx.PageObjects.Home;
import com.dealx.PageObjects.SignIn;
import com.dealx.Validations.Validation;
import com.dealx.utils.BrowserFactory;
import com.dealx.utils.ReadFromExcelFile;
import com.dealx.utils.RepositoryProperties;
import com.dealx.utils.UserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest
{
    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser();
    Home homePageObjects = PageFactory.initElements(driver, Home.class);
    Cart cartPageObjects = PageFactory.initElements(driver, Cart.class);
    SignIn signInPageObjects = PageFactory.initElements(driver, SignIn.class);
    Dresses dresses = PageFactory.initElements(driver, Dresses.class);
    RepositoryProperties property = new RepositoryProperties();
    ReadFromExcelFile readFromExcelFile = new ReadFromExcelFile();
    UserActions actions = new UserActions(driver);
    Validation validation = new Validation();
}
