package com.dataart.selenium.pagesmethods;

import com.dataart.selenium.pages.MainPageMy;
import com.dataart.selenium.pages.MyAppPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by apapushyna on 06.02.2015.
 */
public class MyAppPageMethods {
    WebDriver driver;
    MyAppPage myapppage;

    public MyAppPageMethods(MyAppPage myapppage){
        this.myapppage = myapppage;
    }

    public void create_newapp(){
        myapppage.newapp_button.click();
    }
}
