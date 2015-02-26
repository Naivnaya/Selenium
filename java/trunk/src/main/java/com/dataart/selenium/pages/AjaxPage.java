package com.dataart.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by apapushyna on 09.02.2015.
 */
public class AjaxPage {
    WebDriver driver;
    public AjaxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='x']")@CacheLookup    public WebElement x_field;
    @FindBy(xpath = "//input[@id='y']")@CacheLookup public WebElement y_field;
    @FindBy(xpath = "//button[@id='calc']")@CacheLookup public WebElement sum_button;
//    @FindBy(xpath = "//div[@id='result']")@CacheLookup public WebElement result_mess;

    public String getResult_message() {
        return driver.findElement(By.xpath("//div[@id='result']")).getText();
    }

    public final By result_message = By.xpath("//div[@id='result']");

    }

