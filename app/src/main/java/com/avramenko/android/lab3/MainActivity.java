package com.avramenko.android.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FileReader fileReader;
    private FileWriter fileWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileReader = new FileReader();
        fileWriter = new FileWriter();
    }

    public  void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        RadioGroup radGrp = (RadioGroup)findViewById(R.id.radios);
        if (editText.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, "Enter question first.", Toast.LENGTH_LONG);
            toast.show();
        }
        else if (radGrp.getCheckedRadioButtonId() == -1){
            Toast toast = Toast.makeText(this, "Select answer.", Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            int selectedId = radGrp.getCheckedRadioButtonId();
            RadioButton radioBttn = (RadioButton) findViewById(selectedId);
            String str = editText.getText().toString() + " " + radioBttn.getText().toString();
            Toast toast = Toast.makeText(this, str, Toast.LENGTH_LONG);
            toast.show();

            fileWriter.saveText(view, str+ "\n");
        }
    }

    public void openDataFile(View view){
        String str = fileReader.openText(view);
        if (str.equals("")){
            Toast toast = Toast.makeText(view.getContext(), "File is empty.", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            Intent intent = new Intent(this, FileContentActivity.class);
            intent.putExtra("str", str);
            startActivity(intent);
        }
    }
}
