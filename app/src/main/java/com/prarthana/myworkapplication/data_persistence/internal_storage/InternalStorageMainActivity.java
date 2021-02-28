package com.prarthana.myworkapplication.data_persistence.internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalStorageMainActivity extends AppCompatActivity {

    EditText inputField;
    Button writeBtn,readBtn;
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_main);

        inputField = findViewById(R.id.inputField);
        writeBtn = findViewById(R.id.writeBtn);
        readBtn = findViewById(R.id.readBtn);
        displayText = findViewById(R.id.displayText);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFile();
            }
        });
        
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });
    }

    private void readFile() {
        try {
            FileInputStream fileInputStream = openFileInput("Tutorial File.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while((lines = bufferedReader.readLine()) != null){
                stringBuffer.append(lines + "\n");
            }

            displayText.setText(stringBuffer.toString());

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void writeFile() {
        String textToSave = inputField.getText().toString();

        try{
            FileOutputStream fileOutputStream = openFileOutput("Tutorial File.txt",MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();

            Toast.makeText(this, "Text Saved", Toast.LENGTH_SHORT).show();
            inputField.setText("");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}