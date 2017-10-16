package com.winiter.everyutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileUtils {

    /**
     * copy file
     *
     * @param form path of source file
     * @param to   path of target file
     */
    public static void copyFile(String form, String to) {
        File fileFrom = new File(form);
        if (!fileFrom.exists() || !fileFrom.isFile() || !fileFrom.canRead()) {
            return;
        }
        try {
            InputStream is = new FileInputStream(form); //读入原文件
            FileOutputStream fos = new FileOutputStream(to);
            byte[] buffer = new byte[1024];
            int byteread;
            while ((byteread = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteread);
            }
            is.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
