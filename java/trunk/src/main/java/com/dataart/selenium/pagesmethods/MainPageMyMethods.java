package com.dataart.selenium.pagesmethods;
import com.dataart.selenium.pages.*;


/**
 * Created by apapushyna on 30.01.2015.
 */
public class MainPageMyMethods {

    MainPageMy mainpagemy;

    public MainPageMyMethods(MainPageMy mainpagemy){
        this.mainpagemy = mainpagemy;
    }
    public void logout(){
        mainpagemy.exit_link.click();
    }
    public void app_details(){
       mainpagemy.app_details_button.click();
    }
    public void to_myapp(){
        mainpagemy.myapplication_button.click();
    }
    public void to_ajax_test(){
        mainpagemy.ajax_test_button.click();
    }
    public void to_js_test(){
        mainpagemy.js_test_button.click();
    }
    public void to_any_app_details(){
        mainpagemy.any_app_details_button.click();
    }
   }
