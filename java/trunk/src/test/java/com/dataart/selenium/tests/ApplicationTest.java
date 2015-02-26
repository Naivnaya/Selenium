package com.dataart.selenium.tests;

import com.dataart.selenium.Entity.Application;
import com.dataart.selenium.Entity.User;
import com.dataart.selenium.pages.*;
import com.dataart.selenium.pagesmethods.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import static com.dataart.selenium.Entity.UserBuilder.admin;
import static com.dataart.selenium.Entity.UserBuilder.dev;
import static com.dataart.selenium.Entity.ApplicationBuilder.*;
import static java.lang.Thread.sleep;
import static org.fest.assertions.Assertions.assertThat;

/**
* Created by apapushyna on 05.02.2015.
*/
public class ApplicationTest {
    WebDriver driver;
    RegistrationPage registrationpage;
    RegistrationPageMethods registrationpagemethods;
    LoginPageMy loginpagemy;
    LoginPageMyMethods loginpagemymethods;
    User user;
    MainPageMy mainpagemy;
    MainPageMyMethods mainpagemymethod;
    CreateAppPage createapppage;
    CreateAppPageMethods createapppagemethods;
    MyAppPage myapppage;
    MyAppPageMethods myapppagemethods;
    ViewOneAppPage viewoneapppage;
    ViewOneAppPageMethods viewoneapppagemethods;
    Application application;
    DownloadPage downloadpage;
    DownloadPageMethods downloadpagemethods;
    EditAppPage editapppage;
    EditAppPageMethods editapppagemethods;


    @BeforeMethod
    public void beforemethod() {
        driver = new FirefoxDriver();
        registrationpage = new RegistrationPage(driver);
        registrationpagemethods = new RegistrationPageMethods(registrationpage);
        loginpagemy = new LoginPageMy(driver);
        loginpagemymethods = new LoginPageMyMethods(loginpagemy);
        mainpagemy = new MainPageMy(driver);
        mainpagemymethod = new MainPageMyMethods(mainpagemy);
        createapppage = new CreateAppPage(driver);
        createapppagemethods = new CreateAppPageMethods(createapppage);
        myapppage = new MyAppPage(driver);
        myapppagemethods = new MyAppPageMethods(myapppage);
        viewoneapppage = new ViewOneAppPage(driver);
        viewoneapppagemethods = new ViewOneAppPageMethods(viewoneapppage);
        downloadpage = new DownloadPage(driver);
        downloadpagemethods = new DownloadPageMethods(downloadpage);
        editapppage = new EditAppPage(driver);
        editapppagemethods = new EditAppPageMethods(editapppage);
        driver.get("http://localhost:8080/");
    }

    @AfterMethod
    public void aftermethod() {
        try{sleep(2000);} catch (InterruptedException ex){}
//        driver.quit();
    }



//Json parsing
   @Test
   public void parsing(){
    user = admin();
    loginpagemymethods.login(user);
    mainpagemymethod.to_any_app_details();
       System.setProperty("app_title1", viewoneapppage.getAppName());
       System.setProperty("app_descpiption1", viewoneapppage.getAppDiscription());
       System.setProperty("app_category1", viewoneapppage.getAppCategory());
       System.setProperty("author1", viewoneapppage.getAppAuthor());
       System.setProperty("numb_downloads1", viewoneapppage.getAppNumbDownloads());
    viewoneapppagemethods.download_app();
    downloadpagemethods.main();
       assert_app_viev();
    }


//    Create new application without images. Verify it is displayed correctly and can be downloaded.

    @Test
    public void app_without_img(){
        user = dev();
        application = Orange();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
        mainpagemymethod.to_myapp();
        myapppagemethods.create_newapp();
        createapppagemethods.create_app_without_img(application);
        String new_xpath = ("//div[contains(text(),'" + application.getAppname() + "')]/following-sibling::a");
        WebElement to_app_button = driver.findElement(By.xpath(new_xpath));
        to_app_button.click();
        assert_app_info(application);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewoneapppage.download_button_text));

    }

//    Edit application without images and verify that changes applied.
    @Test
    public void edit_app(){
        user = dev();
        application = Orange();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
        mainpagemymethod.to_myapp();
        myapppagemethods.create_newapp();
        createapppagemethods.create_app_without_img(application);
        String new_xpath = ("//div[contains(text(),'" + application.getAppname() + "')]/following-sibling::a");
        WebElement to_app_button = driver.findElement(By.xpath(new_xpath));
        to_app_button.click();
        viewoneapppagemethods.edit_app();
        editapppagemethods.edit_app(application);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(editapppage.edited_message));

    }

//Create new application with image and icon.
    @Test
    public void app_with_img(){
        user = dev();
        application = Orange();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
        mainpagemymethod.to_myapp();
        myapppagemethods.create_newapp();
        createapppagemethods.create_app_with_img(application);
    }

// Create an application and download it many times. Verify that it is in most popular section and if you click it there you will be navigated to details page for this application.
    @Test
    public void download_app_many_times(){
        user = dev();
        application = Orange();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
        mainpagemymethod.to_myapp();
        myapppagemethods.create_newapp();
        createapppagemethods.create_app_without_img(application);
        String new_xpath = ("//div[contains(text(),'" + application.getAppname() + "')]/following-sibling::a");
        WebElement to_app_button = driver.findElement(By.xpath(new_xpath));
        to_app_button.click();
        System.setProperty("currenturl", driver.getCurrentUrl());
        viewoneapppagemethods.download_app();
        int i = 1;
        while (i < 10) {
            driver.get(System.getProperty("currenturl"));
            viewoneapppage = new ViewOneAppPage(driver);
            viewoneapppagemethods = new ViewOneAppPageMethods(viewoneapppage);
            viewoneapppagemethods.download_app();
            driver.get(System.getProperty("currenturl"));
            i++;
        }
        String new_xpath2 = ("//div[@class='popular-container']//div[contains(text(),'" + application.getAppname() + "')]");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(new_xpath2)));
    }

//   Delete an application and verify it is removed.
    @Test
    public void delete_app(){
        user = dev();
        application = Orange();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
        mainpagemymethod.to_myapp();
        myapppagemethods.create_newapp();
        createapppagemethods.create_app_without_img(application);
        String new_xpath = ("//div[contains(text(),'" + application.getAppname() + "')]/following-sibling::a");
        WebElement to_app_button = driver.findElement(By.xpath(new_xpath));
        to_app_button.click();
        viewoneapppagemethods.delete_app();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Deleted')]")));
    }

    private void assert_app_info(Application application){
        assertThat(viewoneapppage.getAppName()).isEqualTo(application.getAppname());
        assertThat(viewoneapppage.getAppDiscription()).isEqualTo("Description: " + application.getAppdescription());
        assertThat(viewoneapppage.getAppCategory()).isEqualTo("Category: " + System.getProperty("dropdown_value"));
        assertThat(viewoneapppage.getAppAuthor()).isEqualTo("Author: " + user.getUsername());
    }

    private void assert_app_viev(){
        assertThat(System.getProperty("app_title1")).isEqualTo(System.getProperty("title2"));
        assertThat(System.getProperty("app_descpiption1")).isEqualTo("Description: " + System.getProperty("app_description2"));
        assertThat(System.getProperty("app_category1")).isEqualTo("Category: " + System.getProperty("app_category2"));
        assertThat(System.getProperty("author1")).isEqualTo("Author: " + System.getProperty("author2"));
        assertThat(System.getProperty("numb_downloads1")).isEqualTo("# of downloads: " + System.getProperty("numb_downloads2"));
    }


    }