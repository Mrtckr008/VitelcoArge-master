package com.example.vitelcoarge.Model;

import com.example.vitelcoarge.Volley.ResponseTokenJsonParse;

public class GetTokenResponseModel {
    private static String user;
    private static Integer id;

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        GetTokenResponseModel.user = user;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        GetTokenResponseModel.id = id;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        GetTokenResponseModel.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        GetTokenResponseModel.password = password;
    }

    public static Integer getIsSuccess() {
        return isSuccess;
    }

    public static void setIsSuccess(Integer isSuccess) {
        GetTokenResponseModel.isSuccess = isSuccess;
    }

    public static String getErrorCode() {
        return errorCode;
    }

    public static void setErrorCode(String errorCode) {
        GetTokenResponseModel.errorCode = errorCode;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }

    public static void setErrorMessage(String errorMessage) {
        GetTokenResponseModel.errorMessage = errorMessage;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        GetTokenResponseModel.token = token;
    }

    private static String userName;
    private static String password;
    private static Integer isSuccess;
    private static String errorCode;
    private static String errorMessage;
    private static String token;



}
