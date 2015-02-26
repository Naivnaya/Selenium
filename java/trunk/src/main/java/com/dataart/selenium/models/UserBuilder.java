package com.dataart.selenium.models;

public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Ivan");
        user.setLname("Petrov");
        return user;
    }

    public static User romka() {
        User user = new User("Roma123", "123");
        user.setFname("Roma");
        user.setLname("Ivanov");
        return user;
    }
}
