package com.sambilan.sambilan.utils;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by Afriandi Haryanto on 2/12/2018.
 */

public class Base64ImageManager {

    private static Base64ImageManager manager;
    private final String base64Image = "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";

    private Base64ImageManager() {

    }

    public static Base64ImageManager getManager() {

        if(null == manager)
            manager = new Base64ImageManager();

        return manager;
    }

    public Bitmap decodeFromBase64ToBitmap(String encodedImage) {
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;
    }

    public String convertToBase64(String imagePath)
    {
        Bitmap bm = BitmapFactory.decodeFile(imagePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArrayImage = baos.toByteArray();
        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

        return encodedImage;
    }

    public Bitmap setDefaultImage() {
        return decodeFromBase64ToBitmap(base64Image);
    }
}
