package com.dataart.selenium.pagesmethods;

import com.dataart.selenium.Entity.User;
import com.dataart.selenium.pages.*;
import com.dataart.selenium.Entity.*;

/**
 * Created by apapushyna on 30.01.2015.
 */
public class LoginPageMyMethods {

    LoginPageMy loginpagemy;

    public LoginPageMyMethods(LoginPageMy loginpagemy){
                this.loginpagemy = loginpagemy;
    }

    public void login(User user){
        loginpagemy.login_field.sendKeys(user.getUsername());
        loginpagemy.password_field.sendKeys(user.getPassword());
        loginpagemy.login_button.click();
    }

    public void to_registration(){
        loginpagemy.to_regis_form.click();
    }
}
