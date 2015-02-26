package com.dataart.selenium.tests;

import com.dataart.selenium.Entity.User;
import com.dataart.selenium.pages.JSPage;
import com.dataart.selenium.pages.LoginPageMy;
import com.dataart.selenium.pages.MainPageMy;
import com.dataart.selenium.pagesmethods.LoginPageMyMethods;
import com.dataart.selenium.pagesmethods.MainPageMyMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import com.dataart.selenium.Entity.*;


import static com.dataart.selenium.Entity.UserBuilder.admin;

import static java.lang.Thread.sleep;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by apapushyna on 16.02.2015.
 */
public class JSTests {
WebDriver driver;
    LoginPageMy loginpagemy;
    MainPageMy mainpagemy;
    LoginPageMyMethods loginpagemymethods;
    MainPageMyMethods mainpagemymethods;
    JSPage jspage;
    User user;

    @BeforeTest
    public void beforemothod(){
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        loginpagemy = new LoginPageMy(driver);
        loginpagemymethods = new LoginPageMyMethods(loginpagemy);
        mainpagemy = new MainPageMy(driver);
        mainpagemymethods= new MainPageMyMethods(mainpagemy);
        jspage = new JSPage(driver);
        user = admin();
                    }

    @AfterTest
    public void aftermethod() {
        try{sleep(2000);} catch (InterruptedException ex){}
//        driver.quit();
    }

    @Test
    public  void find_element_position(){
           loginpagemymethods.login(user);
           mainpagemymethods.to_js_test();
        String left = "";
        String top = "";
                 if (driver instanceof JavascriptExecutor) {
                     JavascriptExecutor js = (JavascriptExecutor) driver;
                     left = (String) js.executeScript("return document.getElementsByClassName('flash')[0].offsetLeft;").toString();
                     top = (String) js.executeScript("return document.getElementsByClassName('flash')[0].offsetTop;").toString();
               }
        System.out.println(left);
        System.out.println(top);
           jspage.top_field.sendKeys(top);
           jspage.left_field.sendKeys(left);
           jspage.process_button.click();
        assertThat(driver.switchTo().alert().getText()).isEqualTo("Whoo Hoooo! Correct!");

    }
//    private void alert_message() {
//        assertThat(driver.switchTo().alert().getText()).isEqualTo("Result is: Incorrect data");
//    }

}
