package com.dataart.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
* Created by apapushyna on 04.02.2015.
*/
public class ViewOneAppPage {
    WebDriver driver;

    public ViewOneAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//a[.='Download']") @CacheLookup public WebElement download_button;
    public final By download_button_text = By.xpath("//a[.='Download']");
    @FindBy(xpath = "//a[.='Edit']") @CacheLookup public WebElement edit_button;
    @FindBy(xpath = "//a[.='Delete']") @CacheLookup public WebElement delete_button;

    public String getAppName() {
        return driver.findElement(By.xpath("//div[@class='name']")).getText();
    }
    public String getAppDiscription() {
        return driver.findElement(By.xpath("//div[@class='name']/following-sibling::*[1]")).getText();
    }
    public String getAppCategory() {
        return driver.findElement(By.xpath("//div[@class='name']/following-sibling::*[2]")).getText();
    }
    public String getAppAuthor() {
        return driver.findElement(By.xpath("//div[@class='name']/following-sibling::*[3]")).getText();
    }
    public String getAppNumbDownloads() {
        return driver.findElement(By.xpath("//*[@class='downloads']")).getText();
    }
}
