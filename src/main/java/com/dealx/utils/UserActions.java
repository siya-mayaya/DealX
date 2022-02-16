package com.dealx.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Random;

public class UserActions
{
    private final WebDriver driver;
    Actions actions;

    public UserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void navigateToWindow(WebDriver driver)
    {
        String newWindow = driver.getWindowHandle();
        driver.switchTo().window(newWindow);
    }

    public WebElement waitForElementToBeClickable(WebElement webElement)
    {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public int generateRandomValue()
    {
        int min = 1;
        int max = 10;

        Random random = new Random();
        int value = random.nextInt(max + min);
        return value;
    }

    public String calculateTotalCost(String quantity, String amount)
    {
        String stringValueOfTotalCost = null;
        try
        {
            DecimalFormat decimal = new DecimalFormat("#.##");
            double totalCost = 0;

            int qty = Integer.parseInt(quantity);
            String stringAmt = Substring(amount);
            Thread.yield();
            double doubleAmountValue = Double.parseDouble(stringAmt);
            totalCost = qty * doubleAmountValue;
            String formattedTotalCost = decimal.format(totalCost);
            stringValueOfTotalCost = "$" + formattedTotalCost;
        }
        catch (NumberFormatException exception)
        {
            exception.getMessage();
            exception.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.getMessage();
            e.printStackTrace();
        }
        return stringValueOfTotalCost;
    }

    public String Substring(String value) throws InterruptedException
    {
        String stringAmt = value.substring(1);
        Thread.sleep(3000);
        return stringAmt;
    }
}
