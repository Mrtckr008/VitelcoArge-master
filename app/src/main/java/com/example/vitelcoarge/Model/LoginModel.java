package com.example.vitelcoarge.Model;

public class LoginModel {
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LoginModel.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        LoginModel.password = password;
    }

    public static String username,password;
}
