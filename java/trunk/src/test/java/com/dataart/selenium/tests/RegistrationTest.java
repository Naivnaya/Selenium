package com.dataart.selenium.tests;


import com.dataart.selenium.Entity.User;
import com.dataart.selenium.pages.RegistrationPage;
import com.dataart.selenium.pagesmethods.RegistrationPageMethods;
import static com.dataart.selenium.framework.Utils.isElementPresent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.Utils.waitForElementNotPresent;
import static java.lang.Thread.sleep;
import com.dataart.selenium.pages.*;
import com.dataart.selenium.pagesmethods.*;

import java.util.concurrent.TimeUnit;

import static com.dataart.selenium.Entity.UserBuilder.*;
import static org.fest.assertions.Assertions.assertThat;



/**
 * Created by apapushyna on 03.02.2015.
 */
public class RegistrationTest {

    WebDriver driver;
    RegistrationPage registrationpage;
    RegistrationPageMethods registrationpagemethods;
    LoginPageMy loginpagemy;
    LoginPageMyMethods loginpagemymethods;
    User user;
    MainPageMy mainpagemy;
    MainPageMyMethods mainpagemymethod;


    @BeforeMethod
    public void beforemethod() {
        driver = new FirefoxDriver();
        registrationpage = new RegistrationPage(driver);
        registrationpagemethods = new RegistrationPageMethods(registrationpage);
        loginpagemy = new LoginPageMy(driver);
        loginpagemymethods = new LoginPageMyMethods(loginpagemy);
        mainpagemy = new MainPageMy(driver);
        mainpagemymethod = new MainPageMyMethods(mainpagemy);
        driver.get("http://localhost:8080/");

    }

    @AfterMethod public void aftermethod() {
        try{sleep(5000);} catch (InterruptedException ex){}
//        driver.quit();
    }


    //    Register new user and verify that it is logged in
    @Test
    public void registration(){
        user = olga();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
        assert_login(user);
    }


    //    Register new user, logout and verify that user can login.
    @Test
    public void registration_logout(){
        user = olga();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
        mainpagemymethod.logout();
        loginpagemymethods.login(user);
        assert_login(user);
    }

//    Register as developer, verify that user can open page to upload application.
    @Test
    public void registration_dev_upload(){
        user = dev();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
        assertThat(mainpagemy.getMyApplication()).isEqualTo("My applications");
    }


//    Register as regular user, verify that user can see applications but cannot upload them.
    @Test
    public void registration_user_upload() {
        user = olga();
        loginpagemymethods.to_registration();
        registrationpagemethods.registration(user);
//        waitForElementNotPresent(mainpagemy.app_text);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(mainpagemy.app_text));
    }



    private void assert_login(User user){
        assertThat(mainpagemy.getWelcome_message()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
    }




}