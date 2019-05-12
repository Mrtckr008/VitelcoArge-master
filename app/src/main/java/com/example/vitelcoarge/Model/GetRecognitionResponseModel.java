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

    public static List<Integer> getAttributesProductId() {
        return attributesProductId;
    }

    public static void setAttributesProductId(List<Integer> attributesProductId) {
        GetRecognitionResponseModel.attributesProductId = attributesProductId;
    }

    public static List<Integer> getAttributesOrderId() {
        return attributesOrderId;
    }

    public static void setAttributesOrderId(List<Integer> attributesOrderId) {
        GetRecognitionResponseModel.attributesOrderId = attributesOrderId;
    }

    public static List<Integer> attributesProductId,attributesOrderId;
public static List<Integer> productCost;

    public static List<Integer> getProductCost() {
        return productCost;
    }

    public static void setProductCost(List<Integer> productCost) {
        GetRecognitionResponseModel.productCost = productCost;
    }

    public static List<Integer> getProductOrderId() {
        return productOrderId;
    }

    public static void setProductOrderId(List<Integer> productOrderId) {
        GetRecognitionResponseModel.productOrderId = productOrderId;
    }

    public static List<Integer> productOrderId;

}
