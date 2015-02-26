package com.dataart.selenium.pagesmethods;

import com.dataart.selenium.pages.ViewOneAppPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by apapushyna on 10.02.2015.
 */
public class ViewOneAppPageMethods {
    ViewOneAppPage viewoneapppage;
    WebDriver driver;

    public ViewOneAppPageMethods(ViewOneAppPage viewoneapppage){
        this.viewoneapppage = viewoneapppage;
    }
    public void download_app(){

        viewoneapppage.download_button.click();
    }
    public void edit_app(){
        viewoneapppage.edit_button.click();
    }
    public  void delete_app(){
        viewoneapppage.delete_button.click();
    }
}


