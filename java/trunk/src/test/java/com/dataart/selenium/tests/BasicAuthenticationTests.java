package com.dataart.selenium.tests;

import com.dataart.selenium.pages.LoginPageMy;
import com.dataart.selenium.pages.MainPageMy;
import com.dataart.selenium.pagesmethods.LoginPageMyMethods;
import com.dataart.selenium.pagesmethods.MainPageMyMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.Entity.UserBuilder.admin;
import static java.lang.Thread.sleep;

/**
 * Created by apapushyna on 21.02.2015.
 */
public class BasicAuthenticationTests {
    WebDriver driver;
    MainPageMy mainpagemy;
    MainPageMyMethods mainpagemymethods;


    @BeforeMethod
    public void beforemethod() {
        driver = new FirefoxDriver();
        mainpagemy = new MainPageMy(driver);
        mainpagemymethods= new MainPageMyMethods(mainpagemy);
        driver.get("http://admin:admin@localhost:8080/");

    }

    @AfterMethod
    public void aftermethod() {
        try{sleep(2000);} catch (InterruptedException ex){}
        driver.quit();
    }

    @Test
    public void basic_authentication(){
        mainpagemymethods.to_myapp();
    }

}
