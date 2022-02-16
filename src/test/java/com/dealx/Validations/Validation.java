package com.dealx.Validations;

import org.testng.Assert;

public class Validation
{
    public void verifyTestResult(String actualValue, String expectedValue)
    {
        Assert.assertEquals(actualValue, expectedValue);
    }
}
