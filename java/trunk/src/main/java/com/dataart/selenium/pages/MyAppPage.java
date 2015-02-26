package com.dataart.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by apapushyna on 06.02.2015.
 * http://localhost:8080/my
 */

public class MyAppPage {

    WebDriver driver;

    public MyAppPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[.='Click to add new application']") @CacheLookup public WebElement newapp_button;

}
