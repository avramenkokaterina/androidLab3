package com.avramenko.android.lab3;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    private final static String FILE_NAME = "text.txt";


    public void saveText(View view, String str){

        FileOutputStream fos = null;
        Context ctx = view.getContext();
        try {
            fos = ctx.openFileOutput(FILE_NAME,  Context.MODE_APPEND);
            fos.write(str.getBytes(), 0, str.getBytes().length);
            Toast.makeText(view.getContext(), "Successful write to file.", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {
            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){
                Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
