package com.dataart.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by apapushyna on 06.02.2015.
 * http://localhost:8080/new
 */
public class CreateAppPage {
    WebDriver driver;

    public CreateAppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='title']") @CacheLookup public WebElement title_field;
    @FindBy(xpath = "//textarea[@name='description']") @CacheLookup public WebElement description_field;
    @FindBy(xpath = "//select[@name='category']") @CacheLookup public WebElement category_dropdown;
    @FindBy(xpath = "//input[@name='image']") @CacheLookup public WebElement image;
    @FindBy(xpath = "//input[@name='icon']") @CacheLookup public WebElement icon;
    @FindBy(xpath = "//input[@type='submit']") @CacheLookup public WebElement create_button;
}

