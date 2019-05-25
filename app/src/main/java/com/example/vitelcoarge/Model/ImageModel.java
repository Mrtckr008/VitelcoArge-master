package com.example.vitelcoarge.Model;

import android.graphics.Bitmap;
import android.util.Base64;

public class ImageModel {
    public static Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public static void setImageBitmap(Bitmap imageBitmap) {
        ImageModel.imageBitmap = imageBitmap;
    }

    public static Bitmap imageBitmap;


    public static String getImageBase64() {
        return imageBase64;
    }

    public static void setImageBase64(String imageBase64) {
        ImageModel.imageBase64 = imageBase64;
    }

    public static String imageBase64;
}
