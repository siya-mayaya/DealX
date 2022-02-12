package com.dealx.Tests;

import com.dealx.PageObjects.Home;
import com.dealx.PageObjects.SignIn;
import com.dealx.utils.BrowserFactory;
import com.dealx.utils.ReadFromExcelFile;
import com.dealx.utils.RepositoryProperties;
import org.openqa.selenium.WebDriver;

public class BaseTest
{
    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser();
    Home homePageObjects = new Home(driver);
    RepositoryProperties property = new RepositoryProperties();
    ReadFromExcelFile readFromExcelFile = new ReadFromExcelFile();
    SignIn signIn = new SignIn(driver);
}
