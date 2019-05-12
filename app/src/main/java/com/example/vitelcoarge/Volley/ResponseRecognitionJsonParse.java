package com.example.vitelcoarge.Volley;

import android.content.Intent;
import android.util.Log;

import com.example.vitelcoarge.Model.GetRecognitionResponseModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResponseRecognitionJsonParse extends GetRecognitionResponseModel {


    List<String> listOfProductName;
    List<Integer> listOfProductId;
    List<String> listOfAttributesName;
    List<String> listOfAttributesValue;
    List<Integer> listOfAttributesId;
    private int count;

    String responseAttributes;
    String responseAttributeByOne;

    ResponseRecognitionJsonParse(String responseApi){
    try {
    JSONObject jsonObjectApi = new JSONObject(String.valueOf(responseApi));

    String products = jsonObjectApi.getString("products");


        listOfProductName = new ArrayList<>();
        listOfProductId=new ArrayList<>();
        listOfAttributesName = new ArrayList<>();
        listOfAttributesValue = new ArrayList<>();
        listOfAttributesId =new ArrayList<>();

        JSONArray jsonResponseArray = new JSONArray(products);
        JSONObject jsonResponseObject;

        for (count = 0; count < jsonResponseArray.length(); count++) {
            jsonResponseObject = jsonResponseArray.getJSONObject(count);
            String productName = jsonResponseObject.getString("name");
            listOfProductName.add(productName);
            listOfProductId.add(count);

            JSONArray jsonObjectAttributes= new JSONArray(products);
            responseAttributes = jsonObjectAttributes.getString(count);

            JSONObject jsonAttributes=new JSONObject(responseAttributes);
            responseAttributeByOne=jsonAttributes.getString("attributes");
          //  listOfAttributes.add(responseAttributeByOne);

            JSONArray jsonAttributesByOne= new JSONArray(responseAttributeByOne);
            String responseAttributeByOne=jsonAttributesByOne.getString(0);

            JSONObject responseEachAttribute=new JSONObject(responseAttributeByOne);
            String attributesName=responseEachAttribute.getString("name");
            String AttributeValue=responseEachAttribute.getString("value");
            Integer AttributeId=responseEachAttribute.getInt("id");

            listOfAttributesName.add(attributesName);
            listOfAttributesValue.add(AttributeValue);
            listOfAttributesId.add(AttributeId);



        }

        setProductName(listOfProductName);
        setProductId(listOfProductId);
        setAttributesId(listOfAttributesId);
        setAttributesName(listOfAttributesName);
        setAttributesValue(listOfAttributesValue);




}
catch (Exception e){
        Log.e("Exception why: ",e.getMessage());
}
    }




}
