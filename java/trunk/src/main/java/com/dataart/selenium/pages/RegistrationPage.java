package com.dataart.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by apapushyna on 03.02.2015.
 */
public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='name']") @CacheLookup public WebElement login_field;
    @FindBy(xpath = "//input[@name='fname']") @CacheLookup public WebElement fname_field;
    @FindBy(xpath = "//input[@name='lname']")@CacheLookup public WebElement lname_field;
    @FindBy(xpath = "//input[@name='password']")@CacheLookup public WebElement password_field;
    @FindBy(xpath = "//input[@name='passwordConfirm']")@CacheLookup public WebElement passwordConfirm_field;
    @FindBy(xpath = "//select[@name='role']")@CacheLookup public WebElement role;
//    @FindBy(xpath = "//select[@name='role']/option/@value[.='DEVELOPER']")@CacheLookup public WebElement role_developer;
    @FindBy(xpath = "//*[@type='submit']")@CacheLookup public WebElement register_button;



}


