package com.dataart.selenium.pagesmethods;

import com.dataart.selenium.pages.DownloadPage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;

/**
 * Created by apapushyna on 10.02.2015.
 */
public class DownloadPageMethods {
    WebDriver driver;
    DownloadPage downloadpage;

    public DownloadPageMethods (DownloadPage downloadpage){
        this.downloadpage = downloadpage;
    }


    public void main() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(downloadpage.getDownload_message());

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.toString());

            String description = (String) jsonObject.get("description");
            System.out.println(description);
            System.setProperty("app_description2", description);

            JSONObject category = (JSONObject) jsonObject.get("category");
//            System.out.println(category.toString());
            String cat_title = (String) category.get("title");
            System.out.println(cat_title);
            System.setProperty("app_category2", cat_title);

            JSONObject author = (JSONObject) jsonObject.get("author");
//            System.out.println(author.toString());
            String author_name = (String) author.get("name");
            System.out.println(author_name);
            System.setProperty("author2", author_name);

            String numberOfDownloads = (String) jsonObject.get("numberOfDownloads").toString();
            System.out.println(numberOfDownloads);
            int x = Integer.parseInt(numberOfDownloads) - 1;
            String y = Integer.toString(x);
            System.setProperty("numb_downloads2",y);

            String title = (String) jsonObject.get("title");
            System.out.println(title);
            System.setProperty("title2", title);



        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }
}
