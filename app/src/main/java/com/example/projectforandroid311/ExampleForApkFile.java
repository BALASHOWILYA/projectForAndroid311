package com.example.projectforandroid311;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExampleForApkFile extends AppCompatActivity {

    private TextView textFromApk;

    private void init(){
        textFromApk = findViewById(R.id.text_from_apk_file);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_for_apk_file);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        String text = readFileFromApk("myFile.txt");
        textFromApk.setText(text);



    }

    private String readFileFromApk(String fileName){
        InputStream inStream = null;
        StringBuilder buffer;
        try{
            inStream = getAssets().open(fileName);
            InputStreamReader sr = new InputStreamReader(inStream);
            BufferedReader reader = new BufferedReader(sr);
            String str;
            buffer = new StringBuilder();
            while ((str = reader.readLine()) != null)
                buffer.append(str).append("\n");
            inStream.close();

        }
        catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e){
            throw  new RuntimeException(e);
        }

        return buffer.toString();

    }
}