package com.dataart.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dataart.selenium.Entity.*;
import static java.lang.Thread.sleep;

/**
 * Created by apapushyna on 30.01.2015.
 */


public class LoginPageMy {
    WebDriver driver;

    public LoginPageMy(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@name = 'j_username']") @CacheLookup public WebElement login_field;
    @FindBy(xpath = "//*[@name = 'j_password']") @CacheLookup public WebElement password_field;
    @FindBy(xpath = "//*[@type = 'submit' and @value = 'Login']") @CacheLookup public WebElement login_button;

    @FindBy(xpath = "//*[contains(text(),'Register as')]") @CacheLookup public WebElement to_regis_form;


}
