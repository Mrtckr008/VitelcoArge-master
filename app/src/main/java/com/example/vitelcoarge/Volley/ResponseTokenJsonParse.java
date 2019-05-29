package com.example.vitelcoarge.Volley;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.vitelcoarge.Local.LocalDatabase;
import com.example.vitelcoarge.Model.GetTokenResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

public class ResponseTokenJsonParse extends GetTokenResponseModel {
    public static String responseToken;
    private static String responseUser;
    private static String responseUserName;
    private static String jsonObjectUserName;
    private static String responseErrorCode;
    private static String responseErrorMessage;
    private static Integer responseId,responseIsSucess;




    ResponseTokenJsonParse(String responseTokenApi) {
        try {


            JSONObject jsonObjectUser = new JSONObject(String.valueOf(responseTokenApi));
            responseUser = jsonObjectUser.getString("user");
            setUser(responseUser);
            //APIdeki user

            JSONObject jsonObjectToken=new JSONObject(responseUser);
            responseToken = jsonObjectToken.getString("token");
            setToken(responseToken);
            Log.i("set calisiyor",responseToken);
            //APIdeki token

            JSONObject jsonObjectId=new JSONObject(responseUser);
            responseId = jsonObjectToken.getInt("id");
            setId(responseId);
            //APIdeki ID

            JSONObject jsonObjectUserName=new JSONObject(responseUser);
            responseUserName = jsonObjectToken.getString("userName");
            setUserName(responseUserName);
            //APIdeki username

            Integer responseIsSucess = jsonObjectUser.getInt("isSuccess");
            setIsSuccess(responseIsSucess);
            //APIdeki isSuccess

            String responseErrorCode = jsonObjectUser.getString("errorCode");
            setErrorCode(responseErrorCode);
            //APIdeki errorCode

            String responseErrorMessage = jsonObjectUser.getString("errorMessage");
            setErrorMessage(responseErrorMessage);
            //APIdeki errorMessage
/*
            Log.i("Sonuccc: ",responseToken);
            Log.i("Sonuccc: ",responseErrorCode);
            Log.i("Sonuccc: ",responseErrorMessage);
            Log.i("Sonuccc: ",responseIsSucess.toString());
            Log.i("Sonuccc: ",responseUserName);
            Log.i("Sonuccc: ",responseId.toString());
*/


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
