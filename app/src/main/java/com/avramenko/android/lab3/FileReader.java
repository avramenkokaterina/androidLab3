package com.avramenko.android.lab3;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {
    private final static String FILE_NAME = "file.txt";

    public String openText(View view) {
        FileInputStream fin = null;
        try {
            Context ctx = view.getContext();
            fin = ctx.openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes, 0, bytes.length);
            String text = new String(bytes);
            return text;
        } catch (IOException ex) {
            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            return "";
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
