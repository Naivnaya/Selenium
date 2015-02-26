package com.dataart.selenium.pagesmethods;

import com.dataart.selenium.Entity.User;
import com.dataart.selenium.pages.MainPageMy;
import com.dataart.selenium.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by apapushyna on 03.02.2015.
 */
public class RegistrationPageMethods {

    RegistrationPage registrationpage;
    WebDriver driver;

    public RegistrationPageMethods(RegistrationPage registrationpage){
        this.registrationpage = registrationpage;
    }

    public MainPageMy registration(User user){
        registrationpage.login_field.sendKeys(user.getUsername());
        registrationpage.fname_field.sendKeys(user.getFname());
        registrationpage.lname_field.sendKeys(user.getLname());
        registrationpage.password_field.sendKeys(user.getPassword());
        registrationpage.passwordConfirm_field.sendKeys(user.getPassword());
        Select role_dropdown = new Select(registrationpage.role);
        role_dropdown.selectByValue(user.getRole());
//        role_dropdown.selectByIndex(2);
        registrationpage.register_button.click();
        return new MainPageMy(driver);
    }



}
