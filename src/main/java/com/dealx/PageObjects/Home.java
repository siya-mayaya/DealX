package com.dealx.PageObjects;

import com.dealx.utils.UserActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home
{
    private final WebDriver driver;
    private Actions actions;
    private UserActions userActions;

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement searchInputField;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default button-search']")
    private WebElement searchBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/h1/span[1]")
    private WebElement searchTerm;

    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    private WebElement signIn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div")
    private WebElement firstItem;

    @FindBy(how = How.XPATH, using = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")
    private WebElement addToCart;

    @FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/div/div/div[2]/h1")
    private WebElement itemName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
    private WebElement closeWindow;

    @FindBy(how = How.XPATH, using = "//a[@title='View my shopping cart']")
    private WebElement cartIcon;

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement dresses;

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a")
    private WebElement eveningDresses;

    public Home(WebDriver driver)
    {
        this.driver = driver;
    }

    public Home enterSearchCriteria(String searchTerm) throws InterruptedException
    {
            Thread.sleep(5000);
            searchInputField.clear();
            searchInputField.sendKeys(searchTerm);

        return this;
    }

    public Home clickSearchBtn()
    {
        searchBtn.click();
        return this;
    }

    public String searchedTerm()
    {
        String search = searchTerm.getText();
        return search;
    }

    public SignIn clickSignInBtn()
    {
        signIn.click();
        return new SignIn(driver);
    }

    public Home scrollToFirstItem()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", firstItem);
        return this;
    }

    public Home addFirstItemToCart()
    {
        hover(firstItem);
        waitForElementToBeClickable(addToCart);
        addToCart.click();
        return this;
    }

    public Home closePopUpWindow()
    {
        waitForElementToBeClickable(closeWindow);
        closeWindow.click();
        return this;
    }

    public Cart clickCartIcon()
    {
        cartIcon.click();
        return new Cart(driver);
    }

    public Home hoverOverDressesMenu()
    {
        waitForElementToBeClickable(dresses);
        hover(dresses);
        return this;
    }

    public Dresses clickEveningDresses()
    {
        waitForElementToBeClickable(eveningDresses);
        eveningDresses.click();
        return new Dresses(driver);
    }

    public WebElement waitForElementToBeClickable(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void hover(WebElement element)
    {
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
