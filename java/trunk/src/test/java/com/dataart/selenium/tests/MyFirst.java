package com.dataart.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import com.dataart.selenium.pages.*;
import com.dataart.selenium.pagesmethods.*;
import com.dataart.selenium.Entity.*;
import static com.dataart.selenium.Entity.UserBuilder.*;


/**
 * Created by apapushyna on 29.01.2015.
 */
public class MyFirst {

    WebDriver driver;
    LoginPageMy loginpagemy;
    MainPageMy mainpagemy;
    LoginPageMyMethods loginpagemymethods;
    MainPageMyMethods mainpagemymethods;
    User user;



    @BeforeMethod public void beforemethod() {
        driver = new FirefoxDriver();
        loginpagemy = new LoginPageMy(driver);
        loginpagemymethods = new LoginPageMyMethods(loginpagemy);
        mainpagemy = new MainPageMy(driver);
        mainpagemymethods= new MainPageMyMethods(mainpagemy);
        driver.get("http://localhost:8080/");
        user = admin();


    }

    @AfterMethod public void aftermethod() {
        try{sleep(2000);} catch (InterruptedException ex){}
        driver.quit();
        }
//Login as valid user
    @Test
    public void login_logout(){
        loginpagemymethods.login(user);
        mainpagemymethods.logout();
    }
//Login as valid user with incorrect password
    @Test
    public void incorrect_login(){
        user.setPassword(user.getPassword()+"2222");
        loginpagemymethods.login(user);
    }

}





