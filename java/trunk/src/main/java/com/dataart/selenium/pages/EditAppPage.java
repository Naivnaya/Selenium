package com.dataart.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
* Created by apapushyna on 04.02.2015.
 * http://localhost:8080/edit?title=
*/
public class EditAppPage {
    WebDriver driver;

    public EditAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    public String getEditedMessage() {
//        return driver.findElement(By.xpath("//*[contains(text(),'Application edited')]")).getText();
//    }

    @FindBy(xpath = "//textarea[@name='description']") @CacheLookup public WebElement description_field;
    @FindBy(xpath = "//select[@name='category']") @CacheLookup public WebElement category_dropdown;
    @FindBy(xpath = "//input[@name='image']") @CacheLookup public WebElement image;
    @FindBy(xpath = "//input[@name='icon']") @CacheLookup public WebElement icon;
    @FindBy(xpath = "//*[@type='submit']") @CacheLookup public WebElement update_button;

    public final By edited_message = By.xpath("//*[contains(text(),'Application edited')]");
}
