package com.example.vitelcoarge.Model;

import java.util.ArrayList;
import java.util.List;

public class GetRecognitionResponseModel {
    public static List<String> getProductName() {
        return productName;
    }

    public static void setProductName(List<String> productName) {
        GetRecognitionResponseModel.productName = productName;
    }

    public static List<String> getAttributesName() {
        return attributesName;
    }

    public static void setAttributesName(List<String> attributesName) {
        GetRecognitionResponseModel.attributesName = attributesName;
    }

    public static List<String> getAttributesValue() {
        return attributesValue;
    }

    public static void setAttributesValue(List<String> attributesValue) {
        GetRecognitionResponseModel.attributesValue = attributesValue;
    }

    public static List<Integer> getAttributesId() {
        return attributesId;
    }

    public static void setAttributesId(List<Integer> attributesId) {
        GetRecognitionResponseModel.attributesId = attributesId;
    }

    public static List<Integer> getProductId() {
        return productId;
    }

    public static void setProductId(List<Integer> productId) {
        GetRecognitionResponseModel.productId = productId;
    }

    public static List<String> productName,attributesName,attributesValue;
public static List<Integer> attributesId,productId;


}
