package com.dealx.Tests;

import org.testng.annotations.Test;

public class TC6_Dresses extends BaseTest
{
    @Test
    public void loadSubCategory()
    {
        homePageObjects
                .hoverOverDressesMenu()
                .clickEveningDresses();
        validation
                .verifyTestResult(property.EnvProperties("dressPageTitle"), dresses.pageTitle());

        browserFactory.teardown();
    }
}
