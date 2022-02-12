package com.dealx.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RepositoryProperties
{
    private String stringValueOfPropertiesFile;
    private FileInputStream input;
    private String location = System.getProperty("user.dir") + "/src/main/resources/Repository/FileRepository.properties";
    private Properties property = new Properties();

    public String EnvProperties(String stringParsedIn)
    {
        try
        {
            input = new FileInputStream(location);
            property.load(input);
            this.stringValueOfPropertiesFile = property.getProperty(stringParsedIn);
        }
        catch(IOException io)
        {
            io.printStackTrace();
        }
        return stringValueOfPropertiesFile;
    }
}
