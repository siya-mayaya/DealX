package com.dealx.Tests;

import org.testng.annotations.Test;

public class TC4_SignIn extends BaseTest
{
    @Test
    public void SignIn()
    {
        homePageObjects.clickSignInBtn();
        signInPageObjects
                .enterEmailAddress()
                .enterPassword()
                .clickSignIn();

        browserFactory.teardown();
    }
}
