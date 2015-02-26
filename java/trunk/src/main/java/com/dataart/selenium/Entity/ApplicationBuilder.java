package com.dataart.selenium.Entity;

import java.util.Random;

/**
 * Created by apapushyna on 06.02.2015.
 */
public class ApplicationBuilder {

    public static Application Orange() {
        Long time = System.currentTimeMillis();
        String appname = "Orange" + time;
        Application application = new Application(appname,"The application is about orange");
//        application.setAppcategory("");
//        category_dropdown.selectByIndex(new Random().nextInt(category_dropdown.getOptions().size()));

        application.setAppimage("C:\\Users\\apapushyna\\Desktop\\sponge_images.jpg");
        application.setAppicon("C:\\Users\\apapushyna\\Desktop\\Mario-icon.png");
        return application;
    }

    public static Application Apple() {
        Long time = System.currentTimeMillis();
        String appname = "Apple" + time;
        Application application = new Application(appname,"The application is about apples");
//        application.setAppcategory("");
//        category_dropdown.selectByIndex(new Random().nextInt(category_dropdown.getOptions().size()));

        application.setAppimage("..\\img\\sponge_images.jpg");
        application.setAppicon("../img/Mario-icon.png");
        return application;
    }
}
