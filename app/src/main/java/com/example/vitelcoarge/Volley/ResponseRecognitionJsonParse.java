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
    List<Integer> listOfAttributeProductId;
    List<Integer> listOfAttributeOrderId;
    List<Integer> listOfProductCost;
    List<Integer> listOfProductOrderId;
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
        listOfAttributeProductId=new ArrayList<>();
        listOfAttributeOrderId=new ArrayList<>();
        listOfProductCost=new ArrayList<>();
        listOfProductOrderId=new ArrayList<>();

        JSONArray jsonResponseArray = new JSONArray(products);
        JSONObject jsonResponseObject;

        for (count = 0; count < jsonResponseArray.length(); count++) {
            jsonResponseObject = jsonResponseArray.getJSONObject(count);
            String productName = jsonResponseObject.getString("name");
            Integer productOrderId=jsonResponseObject.getInt("orderId");
            Integer productCost=jsonResponseObject.getInt("cost");
            listOfProductName.add(productName);
            listOfProductId.add(count);
            listOfProductOrderId.add(productOrderId);
            listOfProductCost.add(productCost);

            JSONArray jsonObjectAttributes= new JSONArray(products);
            responseAttributes = jsonObjectAttributes.getString(count);

            JSONObject jsonAttributes=new JSONObject(responseAttributes);
            responseAttributeByOne=jsonAttributes.getString("attributes");


          //  listOfAttributes.add(responseAttributeByOne);

            JSONArray jsonAttributesByOne= new JSONArray(responseAttributeByOne);
            String responseAttributeByOne=jsonAttributesByOne.getString(0);

            JSONObject responseEachAttribute=new JSONObject(responseAttributeByOne);


            String attributesName=responseEachAttribute.getString("name");
            String attributeValue=responseEachAttribute.getString("value");
            Integer attributeId=responseEachAttribute.getInt("id");
            Integer attributesProductId=responseEachAttribute.getInt("productId");
            Integer attributesOrderId=responseEachAttribute.getInt("orderId");


            listOfAttributesName.add(attributesName);
            listOfAttributesValue.add(attributeValue);
            listOfAttributesId.add(attributeId);
            listOfAttributeProductId.add(attributesProductId);
            listOfAttributeOrderId.add(attributesOrderId);



        }

        setProductName(listOfProductName);
        setProductId(listOfProductId);
        setAttributesId(listOfAttributesId);
        setAttributesName(listOfAttributesName);
        setAttributesValue(listOfAttributesValue);
        setAttributesOrderId(listOfAttributeOrderId);
        setAttributesProductId(listOfAttributeProductId);
        setProductCost(productCost);
        setProductOrderId(productOrderId);




}
catch (Exception e){
        Log.e("Exception why: ",e.getMessage());
}
    }




}
