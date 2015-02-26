package com.dataart.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by apapushyna on 17.02.2015.
 */
public class JSPage {
    WebDriver driver;
    public JSPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='top']")@CacheLookup public WebElement top_field;
    @FindBy(xpath = "//*[@id='left']")@CacheLookup public WebElement left_field;
    @FindBy(xpath = "//*[@id='process']")@CacheLookup public WebElement process_button;
}
