package com.dataart.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.dataart.selenium.framework.Utils.isElementPresent;

/**
 * Created by apapushyna on 30.01.2015.
 * http://localhost:8080/ after login
 */
public class MainPageMy {
    WebDriver driver;

    public MainPageMy(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getWelcome_message() {
        return driver.findElement(By.xpath("//*[@class='welcome']")).getText();
    }
    public String getMyApplication() {
        return driver.findElement(By.xpath("//*[.='My applications']")).getText();
    }

    @FindBy(xpath = "//*[contains(text(), 'Logout')]")@CacheLookup public WebElement exit_link;
    @FindBy(xpath = "//*[@class='app']/a") @CacheLookup public WebElement app_details_button;
    @FindBy(xpath = "//*[.='My applications']") @CacheLookup public WebElement myapplication_button;
    @FindBy(xpath = "//*[.='Ajax test page']") @CacheLookup public WebElement ajax_test_button;
    @FindBy(xpath = "//*[.='JS test page']") @CacheLookup public WebElement js_test_button;
    @FindBy(xpath = "//a[.='Details']") @CacheLookup public WebElement any_app_details_button;





    public final By app_text = By.xpath("//*[.='My applications']");

//    String new_xpath = "//*[.='" + System.getProperty("new_app_name") + "']/";



}