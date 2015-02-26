package com.dataart.selenium.Entity;

public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Ivan");
        user.setLname("Petrov");
        user.setRole("DEVELOPER");
        return user;
    }
    public static User romka() {
        User user = new User("Roma123", "123");
        user.setFname("Ivan");
        user.setLname("Petrov");
        user.setRole("USER");
        return user;
    }
    public static User olga() {
        Long time = System.currentTimeMillis();
        String username = "Olga" + time;
        User user = new User(username, "tyui");
        user.setFname("Olga");
        user.setLname("Lolo");
        user.setRole("USER");
        return user;
    }

    public static User dev() {
        Long time = System.currentTimeMillis();
        String username = "Dev" + time;
        User user = new User(username, "1234");
        user.setFname("Lopi");
        user.setLname("Lolko");
        user.setRole("DEVELOPER");
        return user;
    }

}
