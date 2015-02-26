package com.dataart.selenium.Entity;

/**
 * Created by apapushyna on 30.01.2015.
 */
public class User {
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String role;

    public User(String username, String password){
        this.username = username;
        this.password = password;

    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getRole(){
        return role;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) { this.lname = lname;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setRole(String role) {
        this.role = role;
    }


}
