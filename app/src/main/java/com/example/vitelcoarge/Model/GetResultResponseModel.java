package com.example.vitelcoarge.Model;

public class GetResultResponseModel {
    public static Integer getIsSuccess() {
        return isSuccess;
    }

    public static void setIsSuccess(Integer isSuccess) {
        GetResultResponseModel.isSuccess = isSuccess;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }

    public static void setErrorMessage(String errorMessage) {
        GetResultResponseModel.errorMessage = errorMessage;
    }

    public static String getErrorCode() {
        return errorCode;
    }

    public static void setErrorCode(String errorCode) {
        GetResultResponseModel.errorCode = errorCode;
    }

    public static Integer isSuccess;
    public static String errorMessage,errorCode;
}
