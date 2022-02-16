package com.dealx.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cart 
{
    private final WebDriver driver;

    @FindBy(how = How.ID, using = "cart_quantity_down_1_1_0_0")
    private WebElement decreaseQty;

    @FindBy(how = How.ID, using = "cart_quantity_up_1_1_0_0")
    private WebElement increaseQty;

    @FindBy(how = How.XPATH, using = "//input[@name='quantity_1_1_0_0']")
    private WebElement productQty;

    @FindBy(how = How.ID, using = "product_price_1_1_0")
    private WebElement unitPrice;

    @FindBy(how = How.ID, using = "total_product_price_1_1_0")
    private WebElement totalPrice;

    public Cart(WebDriver driver)
    {
        this.driver = driver;
    }

    public Cart setQty(String quantity)
    {
        productQty.clear();
        productQty.sendKeys(quantity);
        return this;
    }

    public String Price()
    {
        String productUnitPrice = unitPrice.getText();
        return productUnitPrice;
    }

    public String totalProductAmount()
    {
        String totalAmt = totalPrice.getText();
        return totalAmt;
    }
}
