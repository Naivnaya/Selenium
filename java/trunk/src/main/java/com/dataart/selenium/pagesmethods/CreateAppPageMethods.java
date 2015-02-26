package com.dataart.selenium.pagesmethods;

import com.dataart.selenium.pages.CreateAppPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.dataart.selenium.Entity.Application;

import java.util.Random;

/**
 * Created by apapushyna on 06.02.2015.
 */
public class CreateAppPageMethods {
    CreateAppPage createapppage;
    WebDriver driver;

    public CreateAppPageMethods (CreateAppPage createapppage){
        this.createapppage = createapppage;
    }

    public void create_app_without_img(Application application){
        createapppage.title_field.sendKeys(application.getAppname());
        createapppage.description_field.sendKeys(application.getAppdescription());
        Select category_dropdown = new Select(createapppage.category_dropdown);
        int rand = new Random().nextInt(category_dropdown.getOptions().size());
        System.setProperty("dropdown_value", String.valueOf(category_dropdown.getOptions().get(rand).getText()));
        category_dropdown.selectByIndex(rand);
        createapppage.create_button.click();
    }
    public void create_app_with_img(Application application){
        createapppage.title_field.sendKeys(application.getAppname());
        createapppage.description_field.sendKeys(application.getAppdescription());
        Select category_dropdown = new Select(createapppage.category_dropdown);
        int rand = new  Random().nextInt(category_dropdown.getOptions().size());
        System.setProperty("dropdown_value2", String.valueOf(category_dropdown.getOptions().get(rand).getText()));
        category_dropdown.selectByIndex(new Random().nextInt(category_dropdown.getOptions().size()));
        createapppage.image.sendKeys(application.getAppimage());
        createapppage.icon.sendKeys(application.getAppicon());
        createapppage.create_button.click();
    }
    public void  edit_application(){

    }
}
