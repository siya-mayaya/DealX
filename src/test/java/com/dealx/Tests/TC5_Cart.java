package com.dealx.Tests;

import org.testng.annotations.Test;

public class TC5_Cart extends BaseTest
{
    @Test
    public void addItemToCart()
    {
        String randomValue = actions.generateRandomValue()+"";
        homePageObjects
                .scrollToFirstItem()
                .addFirstItemToCart()
                .closePopUpWindow()
                .clickCartIcon();
        cartPageObjects
                .setQty(randomValue);
        cartPageObjects
                .Price();
        cartPageObjects
                .totalProductAmount();
        String totalAmt = actions.calculateTotalCost(randomValue, cartPageObjects.Price());
        validation
                .verifyTestResult(totalAmt, cartPageObjects.totalProductAmount());

        browserFactory.teardown();
    }
}
