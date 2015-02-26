package com.dataart.selenium.Entity;

/**
 * Created by apapushyna on 06.02.2015.
 */
public class Application {
        private String appname;
        private String appdescription;
        private String appcategory;
        private String appauthor;
        private String appimage;
        private String appicon;



        public Application (String appname, String appdescription){
            this.appname = appname;
            this.appdescription = appdescription;
            this.appcategory = appcategory;
            this.appauthor = appauthor;
            this.appimage = appimage;
            this.appicon = appicon;
        }

        public String getAppname(){
            return appname;
        }
        public String getAppdescription(){
            return appdescription;
        }
        public String getAppcategory(){
            return appcategory;
        }
        public String getAppauthor(){
            return appauthor;
        }
    public String getAppimage(){
        return appimage;
    }
    public String getAppicon(){
        return appicon;
    }


    public void setAppname(String fname) {
            this.appname = appname;
        }
        public void setAppdescription(String lname) {
            this.appdescription = appdescription;
        }
        public void setAppcategory(String appcategory) {
            this.appcategory = appcategory;
        }
        public void setAppauthor(String appauthor) {
            this.appauthor = appauthor;
        }
        public void setAppimage(String appimage) {
            this.appimage = appimage;
        }
        public void setAppicon(String appicon) {
            this.appicon = appicon;
        }

    }


