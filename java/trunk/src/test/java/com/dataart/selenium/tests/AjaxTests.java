package com.dataart.selenium.tests;

import com.dataart.selenium.Entity.User;
import com.dataart.selenium.pages.AjaxPage;
import com.dataart.selenium.pages.LoginPageMy;
import com.dataart.selenium.pages.MainPageMy;
import com.dataart.selenium.pages.RegistrationPage;
import com.dataart.selenium.pagesmethods.AjaxPageMethods;
import com.dataart.selenium.pagesmethods.LoginPageMyMethods;
import com.dataart.selenium.pagesmethods.MainPageMyMethods;
import com.dataart.selenium.pagesmethods.RegistrationPageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.Entity.UserBuilder.admin;
import static java.lang.Thread.sleep;
import static org.fest.assertions.Assertions.assertThat;




/**
 * Created by apapushyna on 09.02.2015.
 */
public class AjaxTests {
    WebDriver driver;

    AjaxPage ajaxpage;
    AjaxPageMethods ajaxpagemethods;
    LoginPageMy loginpagemy;
    RegistrationPage registrationpage;
    RegistrationPageMethods registrationpagemethods;
    MainPageMy mainpagemy;
    LoginPageMyMethods loginpagemymethods;
    MainPageMyMethods mainpagemymethods;
    User user;

    @BeforeMethod
    public void before_method(){
        driver = new ChromeDriver();
        ajaxpage = new AjaxPage(driver);
        ajaxpagemethods = new AjaxPageMethods(ajaxpage);
        driver.get("http://localhost:8080/");
        user = admin();
        loginpagemy = new LoginPageMy(driver);
        loginpagemymethods = new LoginPageMyMethods(loginpagemy);
        mainpagemy = new MainPageMy(driver);
        mainpagemymethods= new MainPageMyMethods(mainpagemy);
        registrationpage = new RegistrationPage(driver);
        registrationpagemethods = new RegistrationPageMethods(registrationpage);
    }
    @AfterMethod
    public void aftermethod() {
        try{sleep(2000);} catch (InterruptedException ex){}
        driver.quit();
    }

    @Test
    public void valid_data(){
        loginpagemymethods.login(user);
        mainpagemymethods.to_ajax_test();
        ajaxpagemethods.valid_data();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ajaxpage.result_message));
        assert_correct();
    }


    @Test
    public void invalid_data(){
        loginpagemymethods.login(user);
        mainpagemymethods.to_ajax_test();
        ajaxpagemethods.invalid_data();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ajaxpage.result_message));
        assert_incorrect();
    }

    private void assert_correct() {
        assertThat(ajaxpage.getResult_message()).isEqualTo("Result is: " + ajaxpagemethods.sum() + ".0");
    }

    private void assert_incorrect() {
        assertThat(ajaxpage.getResult_message()).isEqualTo("Result is: Incorrect data");
    }
}


