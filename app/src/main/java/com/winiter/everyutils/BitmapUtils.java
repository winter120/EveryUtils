package com.winiter.everyutils;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BitmapUtils {

    public static boolean saveBitmap2File(Bitmap.CompressFormat format, int quality, Bitmap bitmap, File file){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(format, quality, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
