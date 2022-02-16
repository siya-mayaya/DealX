package com.dealx.Tests;

import org.testng.annotations.Test;

public class TC1_Search extends BaseTest
{
    String searchCriteria = property.EnvProperties("searchCriteria");
    String search;

    @Test
    public void search()
    {
        try
        {
            search = readFromExcelFile.readExcelFile();
            String result;
            String[] searchTerms = search.split(",");
            for (int i = 0; i < searchTerms.length; i++) {
                homePageObjects
                        .enterSearchCriteria(searchTerms[i])
                        .clickSearchBtn();
                result = homePageObjects.searchedTerm().replaceAll("^\"|\"$", "");
                validation
                        .verifyTestResult(result.toLowerCase(), searchTerms[i].toLowerCase());
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        browserFactory.teardown();
    }
}
