package com.dataart.selenium.pagesmethods;

import com.dataart.selenium.pages.AjaxPage;
import com.dataart.selenium.pages.CreateAppPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by apapushyna on 09.02.2015.
 */
public class AjaxPageMethods {
    AjaxPage ajaxpage;
    WebDriver driver;

    public AjaxPageMethods (AjaxPage ajaxpage){
        this.ajaxpage = ajaxpage;
    }

    public void valid_data(){
        input_data("45","8");
    }

    private void input_data(String X,String Y) {
        System.setProperty("x", X);
//        todo: tear up/down
        System.setProperty("y", Y);
        ajaxpage.x_field.sendKeys(System.getProperty("x"));
        ajaxpage.y_field.sendKeys(System.getProperty("y"));
        ajaxpage.sum_button.click();
    }

    public void invalid_data(){
        input_data("45","j");
    }

    public int sum() {
            int x = Integer.parseInt(System.getProperty("x"));
            int y = Integer.parseInt(System.getProperty("y"));
            int z = x + y;
            return z;
    }
    }


