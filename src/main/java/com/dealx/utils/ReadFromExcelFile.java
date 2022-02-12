package com.dealx.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcelFile
{
    private final String excelFilePath = System.getProperty("user.dir") + "/src/main/resources/Repository/SearchCriteria.xlsx";

    public String readExcelFile() throws IOException
    {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = workbook.getSheetAt(0);
        int rows = xssfSheet.getLastRowNum();
        String[] searchTerms =new String[rows+1];

        for(int r = 0; r <= rows; r++)
        {
            searchTerms[r]=xssfSheet.getRow(r).getCell(0).toString();
        }

        return String.join(",",searchTerms);
    }
}
