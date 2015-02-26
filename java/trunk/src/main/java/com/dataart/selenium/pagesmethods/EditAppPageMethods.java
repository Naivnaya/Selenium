package com.dataart.selenium.pagesmethods;

import com.dataart.selenium.pages.DownloadPage;
import com.dataart.selenium.pages.EditAppPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.dataart.selenium.Entity.Application;

import java.util.Random;

/**
 * Created by apapushyna on 11.02.2015.
 */
public class EditAppPageMethods {
    WebDriver driver;
    EditAppPage editapppage;

    public EditAppPageMethods (EditAppPage editapppage){
        this.editapppage = editapppage;
    }
    public void edit_app(Application application){
        editapppage.description_field.sendKeys(application.getAppdescription()+"Changed");
        editapppage.category_dropdown.sendKeys();
        Select category_dropdown = new Select(editapppage.category_dropdown);
        int rand = new Random().nextInt(category_dropdown.getOptions().size());
        System.setProperty("dropdown_value_changed", String.valueOf(category_dropdown.getOptions().get(rand).getText()));
        category_dropdown.selectByIndex(rand);
        editapppage.update_button.click();

    }

}
