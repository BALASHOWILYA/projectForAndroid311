package com.example.projectforandroid311;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class InternalStorageActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView textFromInternalStorageToShow;
    private EditText fileName, fileContents;

    private Button deleteFileButton, createFileButton, writeInFileButton, readInFileButton;


    private  void init(){
        toggleButton = findViewById(R.id.internalstorage_finename_togglebutton);
        fileName = findViewById(R.id.internalstorage_finename);
        fileContents = findViewById(R.id.internalstorage_filecontents);
        deleteFileButton = findViewById(R.id.internalstorage_finename_delete);
        createFileButton = findViewById(R.id.internalstorage_finename_create);
        writeInFileButton = findViewById(R.id.internalstorage_finename_write);
        textFromInternalStorageToShow = findViewById(R.id.show_text_from_internalStorage_id);
        readInFileButton = findViewById(R.id.internalstorage_finename_read);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_internal_storage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        createFileButton.setOnClickListener(v ->{
            createFile(getApplicationContext());
        });
        deleteFileButton.setOnClickListener(v ->{
            deleteFile(getApplicationContext());
        });

        writeInFileButton.setOnClickListener(v ->{
            writeFile(getApplicationContext());
        });
        readInFileButton.setOnClickListener(v ->{
            readFile(getApplicationContext());
        });


    }

    private void createFile(Context context){
        File file;
        file = new File(context.getFilesDir(), fileName.getText().toString());


        if(!file.exists()){
            try{
                file.createNewFile();
               // Toast.makeText(context, String.format("File has been created"), fileName.getText().toString(), Toast.LENGTH_SHORT).show();

            } catch (IOException e){

            }

        }
    }

    private  void writeFile(Context context){
        try{
            FileOutputStream fileOutputStream;
            fileOutputStream = context.openFileOutput(fileName.getText().toString(), Context.MODE_PRIVATE);
            fileOutputStream.write(fileContents.getText().toString().getBytes(Charset.forName("UTF-8")));
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    private void readFile(Context context){
        try {
            FileInputStream fileInputStream;
            fileInputStream = context.openFileInput(fileName.getText().toString());

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
            List<String> lines = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null){
                lines.add(line);
                line = reader.readLine();
            }
            textFromInternalStorageToShow.setText(TextUtils.join("\n", lines));

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    private void deleteFile(Context context){
        File file;
        file = new File(context.getFilesDir(), fileName.getText().toString());
        if(file.exists()){
            file.delete();
        }

    }


}