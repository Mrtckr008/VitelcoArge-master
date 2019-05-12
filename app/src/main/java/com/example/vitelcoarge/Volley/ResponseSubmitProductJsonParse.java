package com.example.vitelcoarge.Volley;

import com.example.vitelcoarge.Model.GetResultResponseModel;

import org.json.JSONObject;

public class ResponseSubmitProductJsonParse {

    public ResponseSubmitProductJsonParse(String responseSubmitApi) {

        Integer isSuccess;
        String errorCode;
        String errorMessage;

        try{

            JSONObject jsonObjectSubmit = new JSONObject(String.valueOf(responseSubmitApi));
            isSuccess = jsonObjectSubmit.getInt("isSuccess");
            GetResultResponseModel.setIsSuccess(isSuccess);
            errorCode=jsonObjectSubmit.getString("errorCode");
            GetResultResponseModel.setErrorCode(errorCode);
            errorMessage=jsonObjectSubmit.getString("errorMessage");
            GetResultResponseModel.setErrorMessage(errorMessage);

        }
        catch (Exception exc){

        }

    }
}
