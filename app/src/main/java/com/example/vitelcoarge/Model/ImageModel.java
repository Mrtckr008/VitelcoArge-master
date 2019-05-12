package com.example.vitelcoarge.Model;

import android.graphics.Bitmap;

public class ImageModel {
    public static Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public static void setImageBitmap(Bitmap imageBitmap) {
        ImageModel.imageBitmap = imageBitmap;
    }

    public static Bitmap imageBitmap;
}
