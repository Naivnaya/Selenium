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
public class DownloadPage {
    WebDriver driver;

    public DownloadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//pre")@CacheLookup public WebElement downloadMessage;

    public String getDownload_message() {
        return driver.findElement(By.xpath("//pre")).getText();
    }
}
